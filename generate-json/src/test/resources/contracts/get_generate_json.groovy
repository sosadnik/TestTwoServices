package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return json list")

    request {
        url("/generate/json")
        method GET()
        body([

                  _id: 1 ,
                  _type: "type" ,
                  coreCountry: true ,
                  country: "country" ,
                  countryCode: "code" ,
                  distance: 1 ,
                  fullName: "fullName" ,
                  geo_position:
                  [
                          latitude : 2,
                          longitude: 3
                  ] ,
                  iata_airport_code: "airport_code" ,
                  inEurope: true ,
                  key: "kay" ,
                  location_id: 1 ,
                  name: "name" ,
                  type: "type"

        ])
    }

    response {
        status(200)
    }
}
