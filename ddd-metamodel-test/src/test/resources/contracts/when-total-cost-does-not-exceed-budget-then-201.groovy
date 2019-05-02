package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("contract-for-when-total-cost-does-not-exceed-budget")
    description """
Success scenario when scheduling a conference
 
```
given:
 the conference's budget is 1000 euros 
and:
 the conference's has a talk that costs 400 euros 
and:
 the conference's has a talk that costs 600 euros 
when:
 the user tries to schedule the conference
then:
 it is accepted
```
 
"""
    request {
        method 'POST'
        urlPath('/example-app/conferences/')
        body(
            budget: 1000,
            costs: [400, 600]
        )
        headers {
            contentType("application/json;charset=UTF-8")
            accept("application/json;charset=UTF-8")
        }
    }

    response {
        status 201
        headers {}
    }
}