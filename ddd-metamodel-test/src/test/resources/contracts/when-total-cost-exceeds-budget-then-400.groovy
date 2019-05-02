package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("contract-for-when-total-cost-exceeds-budget")
    description """
Failure scenario when scheduling a conference
 
```
given:
 the conference's budget is 1000 euros 
and:
 the conference's has a talk that costs 400 euros 
and:
 the conference's has a talk that costs 700 euros 
when:
 the user tries to schedule the conference
then:
 it is rejected
```
 
"""
    request {
        method 'POST'
        urlPath('/example-app/conferences/')
        body(
            budget: 1000,
            costs: [400, 700]
        )
        headers {
            contentType("application/json;charset=UTF-8")
            accept("application/json;charset=UTF-8")
        }
    }

    response {
        status 400
        headers {}
    }
}