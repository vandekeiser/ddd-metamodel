package fr.cla.ddd.metamodel.exampleapp.infra.equatability;

import fr.cla.ddd.metamodel.AbstractAggregateRoot;
import fr.cla.ddd.metamodel.exampleapp.domain.ConferenceId;
import fr.cla.ddd.metamodel.exampleapp.infra.JpaConfig;
import org.hibernate.proxy.HibernateProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TestTransaction;

import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;

//@formatter:off
@DataJpaTest
@ContextConfiguration(classes = JpaConfig.class)
public abstract class AbstractSdjConferencesTest<
    C extends AbstractAggregateRoot<C, ConferenceId>
> {

    @Test
    public void reloaded_lazy_proxy_should_be_equal() {
        reloaded_lazy_proxy_should_be_equal(doesEqualWorkWithProxies());
    }

    private void reloaded_lazy_proxy_should_be_equal(
        boolean expectedEquals
    ) {
        C persistedConf;

        given: {
            //() -> sut.add(persistedConf)
            persistedConf = doInAnotherTransaction(this::addConference);
        }

        doInAnotherTransaction( () -> {
            C lazyProxy;

            when: {
                lazyProxy = loadLazyProxy(persistedConf.getId());
            }

            then: {
                //It's not the same...
                assertThat(lazyProxy).isNotSameAs(persistedConf);
                assertThat(lazyProxy.getClass()).isNotEqualTo(persistedConf.getClass());

                if(expectedEquals) {
                    assertThat(lazyProxy).isEqualTo(persistedConf);
                } else {
                    assertThat(lazyProxy).isNotEqualTo(persistedConf);
                }
            }

            return null;//because this Callable is void
        });
    }

    private C loadLazyProxy(ConferenceId id) {
        //C reloadedConf = sdj.getOne(id);
        C reloadedConf = loadLazyProxyFor(id);

        //Sanity check that it is really a lazy proxy
        assertThat(reloadedConf instanceof HibernateProxy).isTrue();

        //Check that, because it doesn't work when getId() is final
        assertThat(reloadedConf.getId()).isEqualTo(id);

        return reloadedConf;
    }

    private C doInAnotherTransaction(Callable<C> addToRepository) {
        if(TestTransaction.isActive()) {
            TestTransaction.end();
        }

        TestTransaction.start();
        try {
            C persisted = addToRepository.call();
            TestTransaction.flagForCommit();
            return persisted;
        } catch (Throwable t) {
            TestTransaction.flagForRollback();
            throw new AssertionError(t);
        } finally {
            TestTransaction.end();
        }
    }

    protected abstract boolean doesEqualWorkWithProxies();

    protected abstract C addConference();

    protected abstract C loadLazyProxyFor(ConferenceId id);

}
//@formatter:on