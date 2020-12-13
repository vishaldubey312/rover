# rover

This is the entire maven project, which was build using spring boot. A WAR file is also uploaded with this project inside the root directory which can be used to run this project.

Some of th erequest bodies areprovided herewith which should be used as they are(some data with uppercase, enums were used)


{"scenarios":[{"name":"battery-low","conditions":[{"type":"rover","property":"battery","operator":"lte","value":2}],"rover":[{"is":"immobile"}]},{"name":"encountering-water","conditions":[{"type":"environment","property":"terrain","operator":"eq","value":"water"}],"rover":[{"performs":{"collect-sample":{"type":"WATER_SAMPLE","qty":2}}}]},{"name":"encountering-storm","conditions":[{"type":"environment","property":"storm","operator":"eq","value":true}],"rover":[{"performs":{"item-usage":{"type":"STORM_SHIELD","qty":1}}}]}],"states":[{"name":"normal","allowed-actions":["MOVE","COLLECT_SAMPLE"]},{"name":"immobile","allowed-actions":["COLLECT_SAMPLE"]}],"deploy-point":{"row":3,"column":1},"initial-battery":11,"inventory":[{"type":"STORM_SHIELD","quantity":1,"priority":1}]}


{
    "direction": "UP"
}

{"temperature":60,"humidity":65,"solar-flare":false,"storm":false,"area-map":[["DIRT","DIRT","DIRT","WATER","DIRT"],["DIRT","DIRT","WATER","WATER","WATER"],["DIRT","DIRT","DIRT","WATER","DIRT"],["DIRT","DIRT","DIRT","DIRT","DIRT"],["DIRT","DIRT","DIRT","DIRT","DIRT"]]}


Thanks
