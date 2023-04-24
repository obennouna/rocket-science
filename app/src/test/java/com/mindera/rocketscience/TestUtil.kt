package com.mindera.rocketscience

import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.companyinfo.Headquarters
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import com.squareup.moshi.Moshi

class TestUtil {
    companion object {
        fun createCompanyInfo(): CompanyInfo {
            return CompanyInfo(
                "Mindera",
                "George",
                1991,
                1,
                1,
                0,
                0,
                "George",
                "George",
                "George",
                "George",
                10,
                Headquarters("Address", "City", "State"),
                "Big Summary"
            )
        }

        fun createLaunchesInfo(): List<Launch> {
            val moshi = Moshi.Builder().build()
            val launch1: Launch = moshi.adapter(Launch::class.java).fromJson(
                "{\n" +
                        "        \"fairings\": {\n" +
                        "            \"reused\": false,\n" +
                        "            \"recovery_attempt\": false,\n" +
                        "            \"recovered\": false,\n" +
                        "            \"ships\": []\n" +
                        "        },\n" +
                        "        \"links\": {\n" +
                        "            \"patch\": {\n" +
                        "                \"small\": \"https://images2.imgbox.com/94/f2/NN6Ph45r_o.png\",\n" +
                        "                \"large\": \"https://images2.imgbox.com/5b/02/QcxHUb5V_o.png\"\n" +
                        "            },\n" +
                        "            \"reddit\": {\n" +
                        "                \"campaign\": null,\n" +
                        "                \"launch\": null,\n" +
                        "                \"media\": null,\n" +
                        "                \"recovery\": null\n" +
                        "            },\n" +
                        "            \"flickr\": {\n" +
                        "                \"small\": [],\n" +
                        "                \"original\": []\n" +
                        "            },\n" +
                        "            \"presskit\": null,\n" +
                        "            \"webcast\": \"https://www.youtube.com/watch?v=0a_00nJ_Y88\",\n" +
                        "            \"youtube_id\": \"0a_00nJ_Y88\",\n" +
                        "            \"article\": \"https://www.space.com/2196-spacex-inaugural-falcon-1-rocket-lost-launch.html\",\n" +
                        "            \"wikipedia\": \"https://en.wikipedia.org/wiki/DemoSat\"\n" +
                        "        },\n" +
                        "        \"static_fire_date_utc\": \"2006-03-17T00:00:00.000Z\",\n" +
                        "        \"static_fire_date_unix\": 1142553600,\n" +
                        "        \"net\": false,\n" +
                        "        \"window\": 0,\n" +
                        "        \"rocket\": \"5e9d0d95eda69955f709d1eb\",\n" +
                        "        \"success\": false,\n" +
                        "        \"failures\": [\n" +
                        "            {\n" +
                        "                \"time\": 33,\n" +
                        "                \"altitude\": null,\n" +
                        "                \"reason\": \"merlin engine failure\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"details\": \"Engine failure at 33 seconds and loss of vehicle\",\n" +
                        "        \"crew\": [],\n" +
                        "        \"ships\": [],\n" +
                        "        \"capsules\": [],\n" +
                        "        \"payloads\": [\n" +
                        "            \"5eb0e4b5b6c3bb0006eeb1e1\"\n" +
                        "        ],\n" +
                        "        \"launchpad\": \"5e9e4502f5090995de566f86\",\n" +
                        "        \"flight_number\": 1,\n" +
                        "        \"name\": \"FalconSat\",\n" +
                        "        \"date_utc\": \"2006-03-24T22:30:00.000Z\",\n" +
                        "        \"date_unix\": 1143239400,\n" +
                        "        \"date_local\": \"2006-03-25T10:30:00+12:00\",\n" +
                        "        \"date_precision\": \"hour\",\n" +
                        "        \"upcoming\": false,\n" +
                        "        \"cores\": [\n" +
                        "            {\n" +
                        "                \"core\": \"5e9e289df35918033d3b2623\",\n" +
                        "                \"flight\": 1,\n" +
                        "                \"gridfins\": false,\n" +
                        "                \"legs\": false,\n" +
                        "                \"reused\": false,\n" +
                        "                \"landing_attempt\": false,\n" +
                        "                \"landing_success\": null,\n" +
                        "                \"landing_type\": null,\n" +
                        "                \"landpad\": null\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"auto_update\": true,\n" +
                        "        \"tbd\": false,\n" +
                        "        \"launch_library_id\": null,\n" +
                        "        \"id\": \"5eb87cd9ffd86e000604b32a\"\n" +
                        "    }"
            )!!
            val launch2: Launch = moshi.adapter(Launch::class.java).fromJson(
                "{\n" +
                        "        \"fairings\": {\n" +
                        "            \"reused\": false,\n" +
                        "            \"recovery_attempt\": false,\n" +
                        "            \"recovered\": false,\n" +
                        "            \"ships\": []\n" +
                        "        },\n" +
                        "        \"links\": {\n" +
                        "            \"patch\": {\n" +
                        "                \"small\": \"https://images2.imgbox.com/f9/4a/ZboXReNb_o.png\",\n" +
                        "                \"large\": \"https://images2.imgbox.com/80/a2/bkWotCIS_o.png\"\n" +
                        "            },\n" +
                        "            \"reddit\": {\n" +
                        "                \"campaign\": null,\n" +
                        "                \"launch\": null,\n" +
                        "                \"media\": null,\n" +
                        "                \"recovery\": null\n" +
                        "            },\n" +
                        "            \"flickr\": {\n" +
                        "                \"small\": [],\n" +
                        "                \"original\": []\n" +
                        "            },\n" +
                        "            \"presskit\": null,\n" +
                        "            \"webcast\": \"https://www.youtube.com/watch?v=Lk4zQ2wP-Nc\",\n" +
                        "            \"youtube_id\": \"Lk4zQ2wP-Nc\",\n" +
                        "            \"article\": \"https://www.space.com/3590-spacex-falcon-1-rocket-fails-reach-orbit.html\",\n" +
                        "            \"wikipedia\": \"https://en.wikipedia.org/wiki/DemoSat\"\n" +
                        "        },\n" +
                        "        \"static_fire_date_utc\": null,\n" +
                        "        \"static_fire_date_unix\": null,\n" +
                        "        \"net\": false,\n" +
                        "        \"window\": 0,\n" +
                        "        \"rocket\": \"5e9d0d95eda69955f709d1eb\",\n" +
                        "        \"success\": false,\n" +
                        "        \"failures\": [\n" +
                        "            {\n" +
                        "                \"time\": 301,\n" +
                        "                \"altitude\": 289,\n" +
                        "                \"reason\": \"harmonic oscillation leading to premature engine shutdown\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"details\": \"Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage\",\n" +
                        "        \"crew\": [],\n" +
                        "        \"ships\": [],\n" +
                        "        \"capsules\": [],\n" +
                        "        \"payloads\": [\n" +
                        "            \"5eb0e4b6b6c3bb0006eeb1e2\"\n" +
                        "        ],\n" +
                        "        \"launchpad\": \"5e9e4502f5090995de566f86\",\n" +
                        "        \"flight_number\": 2,\n" +
                        "        \"name\": \"DemoSat\",\n" +
                        "        \"date_utc\": \"2007-03-21T01:10:00.000Z\",\n" +
                        "        \"date_unix\": 1174439400,\n" +
                        "        \"date_local\": \"2007-03-21T13:10:00+12:00\",\n" +
                        "        \"date_precision\": \"hour\",\n" +
                        "        \"upcoming\": false,\n" +
                        "        \"cores\": [\n" +
                        "            {\n" +
                        "                \"core\": \"5e9e289ef35918416a3b2624\",\n" +
                        "                \"flight\": 1,\n" +
                        "                \"gridfins\": false,\n" +
                        "                \"legs\": false,\n" +
                        "                \"reused\": false,\n" +
                        "                \"landing_attempt\": false,\n" +
                        "                \"landing_success\": null,\n" +
                        "                \"landing_type\": null,\n" +
                        "                \"landpad\": null\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"auto_update\": true,\n" +
                        "        \"tbd\": false,\n" +
                        "        \"launch_library_id\": null,\n" +
                        "        \"id\": \"5eb87cdaffd86e000604b32b\"\n" +
                        "    }"
            )!!
            val launch3: Launch = moshi.adapter(Launch::class.java).fromJson(
                "{\n" +
                        "        \"fairings\": {\n" +
                        "            \"reused\": false,\n" +
                        "            \"recovery_attempt\": false,\n" +
                        "            \"recovered\": false,\n" +
                        "            \"ships\": []\n" +
                        "        },\n" +
                        "        \"links\": {\n" +
                        "            \"patch\": {\n" +
                        "                \"small\": \"https://images2.imgbox.com/6c/cb/na1tzhHs_o.png\",\n" +
                        "                \"large\": \"https://images2.imgbox.com/4a/80/k1oAkY0k_o.png\"\n" +
                        "            },\n" +
                        "            \"reddit\": {\n" +
                        "                \"campaign\": null,\n" +
                        "                \"launch\": null,\n" +
                        "                \"media\": null,\n" +
                        "                \"recovery\": null\n" +
                        "            },\n" +
                        "            \"flickr\": {\n" +
                        "                \"small\": [],\n" +
                        "                \"original\": []\n" +
                        "            },\n" +
                        "            \"presskit\": null,\n" +
                        "            \"webcast\": \"https://www.youtube.com/watch?v=v0w9p3U8860\",\n" +
                        "            \"youtube_id\": \"v0w9p3U8860\",\n" +
                        "            \"article\": \"http://www.spacex.com/news/2013/02/11/falcon-1-flight-3-mission-summary\",\n" +
                        "            \"wikipedia\": \"https://en.wikipedia.org/wiki/Trailblazer_(satellite)\"\n" +
                        "        },\n" +
                        "        \"static_fire_date_utc\": null,\n" +
                        "        \"static_fire_date_unix\": null,\n" +
                        "        \"net\": false,\n" +
                        "        \"window\": 0,\n" +
                        "        \"rocket\": \"5e9d0d95eda69955f709d1eb\",\n" +
                        "        \"success\": false,\n" +
                        "        \"failures\": [\n" +
                        "            {\n" +
                        "                \"time\": 140,\n" +
                        "                \"altitude\": 35,\n" +
                        "                \"reason\": \"residual stage-1 thrust led to collision between stage 1 and stage 2\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"details\": \"Residual stage 1 thrust led to collision between stage 1 and stage 2\",\n" +
                        "        \"crew\": [],\n" +
                        "        \"ships\": [],\n" +
                        "        \"capsules\": [],\n" +
                        "        \"payloads\": [\n" +
                        "            \"5eb0e4b6b6c3bb0006eeb1e3\",\n" +
                        "            \"5eb0e4b6b6c3bb0006eeb1e4\"\n" +
                        "        ],\n" +
                        "        \"launchpad\": \"5e9e4502f5090995de566f86\",\n" +
                        "        \"flight_number\": 3,\n" +
                        "        \"name\": \"Trailblazer\",\n" +
                        "        \"date_utc\": \"2008-08-03T03:34:00.000Z\",\n" +
                        "        \"date_unix\": 1217734440,\n" +
                        "        \"date_local\": \"2008-08-03T15:34:00+12:00\",\n" +
                        "        \"date_precision\": \"hour\",\n" +
                        "        \"upcoming\": false,\n" +
                        "        \"cores\": [\n" +
                        "            {\n" +
                        "                \"core\": \"5e9e289ef3591814873b2625\",\n" +
                        "                \"flight\": 1,\n" +
                        "                \"gridfins\": false,\n" +
                        "                \"legs\": false,\n" +
                        "                \"reused\": false,\n" +
                        "                \"landing_attempt\": false,\n" +
                        "                \"landing_success\": null,\n" +
                        "                \"landing_type\": null,\n" +
                        "                \"landpad\": null\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"auto_update\": true,\n" +
                        "        \"tbd\": false,\n" +
                        "        \"launch_library_id\": null,\n" +
                        "        \"id\": \"5eb87cdbffd86e000604b32c\"\n" +
                        "    }"
            )!!
            return listOf(launch1, launch2, launch3)
        }

        fun createRocketsInfo(): List<Rocket> {
            val moshi = Moshi.Builder().build()
            val rocket1: Rocket = moshi.adapter(Rocket::class.java).fromJson(
                "{\n" +
                        "        \"height\": {\n" +
                        "            \"meters\": 22.25,\n" +
                        "            \"feet\": 73\n" +
                        "        },\n" +
                        "        \"diameter\": {\n" +
                        "            \"meters\": 1.68,\n" +
                        "            \"feet\": 5.5\n" +
                        "        },\n" +
                        "        \"mass\": {\n" +
                        "            \"kg\": 30146,\n" +
                        "            \"lb\": 66460\n" +
                        "        },\n" +
                        "        \"first_stage\": {\n" +
                        "            \"thrust_sea_level\": {\n" +
                        "                \"kN\": 420,\n" +
                        "                \"lbf\": 94000\n" +
                        "            },\n" +
                        "            \"thrust_vacuum\": {\n" +
                        "                \"kN\": 480,\n" +
                        "                \"lbf\": 110000\n" +
                        "            },\n" +
                        "            \"reusable\": false,\n" +
                        "            \"engines\": 1,\n" +
                        "            \"fuel_amount_tons\": 44.3,\n" +
                        "            \"burn_time_sec\": 169\n" +
                        "        },\n" +
                        "        \"second_stage\": {\n" +
                        "            \"thrust\": {\n" +
                        "                \"kN\": 31,\n" +
                        "                \"lbf\": 7000\n" +
                        "            },\n" +
                        "            \"payloads\": {\n" +
                        "                \"composite_fairing\": {\n" +
                        "                    \"height\": {\n" +
                        "                        \"meters\": 3.5,\n" +
                        "                        \"feet\": 11.5\n" +
                        "                    },\n" +
                        "                    \"diameter\": {\n" +
                        "                        \"meters\": 1.5,\n" +
                        "                        \"feet\": 4.9\n" +
                        "                    }\n" +
                        "                },\n" +
                        "                \"option_1\": \"composite fairing\"\n" +
                        "            },\n" +
                        "            \"reusable\": false,\n" +
                        "            \"engines\": 1,\n" +
                        "            \"fuel_amount_tons\": 3.38,\n" +
                        "            \"burn_time_sec\": 378\n" +
                        "        },\n" +
                        "        \"engines\": {\n" +
                        "            \"isp\": {\n" +
                        "                \"sea_level\": 267,\n" +
                        "                \"vacuum\": 304\n" +
                        "            },\n" +
                        "            \"thrust_sea_level\": {\n" +
                        "                \"kN\": 420,\n" +
                        "                \"lbf\": 94000\n" +
                        "            },\n" +
                        "            \"thrust_vacuum\": {\n" +
                        "                \"kN\": 480,\n" +
                        "                \"lbf\": 110000\n" +
                        "            },\n" +
                        "            \"number\": 1,\n" +
                        "            \"type\": \"merlin\",\n" +
                        "            \"version\": \"1C\",\n" +
                        "            \"layout\": \"single\",\n" +
                        "            \"engine_loss_max\": 0,\n" +
                        "            \"propellant_1\": \"liquid oxygen\",\n" +
                        "            \"propellant_2\": \"RP-1 kerosene\",\n" +
                        "            \"thrust_to_weight\": 96\n" +
                        "        },\n" +
                        "        \"landing_legs\": {\n" +
                        "            \"number\": 0,\n" +
                        "            \"material\": null\n" +
                        "        },\n" +
                        "        \"payload_weights\": [\n" +
                        "            {\n" +
                        "                \"id\": \"leo\",\n" +
                        "                \"name\": \"Low Earth Orbit\",\n" +
                        "                \"kg\": 450,\n" +
                        "                \"lb\": 992\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"flickr_images\": [\n" +
                        "            \"https://imgur.com/DaCfMsj.jpg\",\n" +
                        "            \"https://imgur.com/azYafd8.jpg\"\n" +
                        "        ],\n" +
                        "        \"name\": \"Falcon 1\",\n" +
                        "        \"type\": \"rocket\",\n" +
                        "        \"active\": false,\n" +
                        "        \"stages\": 2,\n" +
                        "        \"boosters\": 0,\n" +
                        "        \"cost_per_launch\": 6700000,\n" +
                        "        \"success_rate_pct\": 40,\n" +
                        "        \"first_flight\": \"2006-03-24\",\n" +
                        "        \"country\": \"Republic of the Marshall Islands\",\n" +
                        "        \"company\": \"SpaceX\",\n" +
                        "        \"wikipedia\": \"https://en.wikipedia.org/wiki/Falcon_1\",\n" +
                        "        \"description\": \"The Falcon 1 was an expendable launch system privately developed and manufactured by SpaceX during 2006-2009. On 28 September 2008, Falcon 1 became the first privately-developed liquid-fuel launch vehicle to go into orbit around the Earth.\",\n" +
                        "        \"id\": \"5e9d0d95eda69955f709d1eb\"\n" +
                        "    }"
            )!!
            val rocket2: Rocket = moshi.adapter(Rocket::class.java).fromJson(
                "{\n" +
                        "        \"height\": {\n" +
                        "            \"meters\": 70,\n" +
                        "            \"feet\": 229.6\n" +
                        "        },\n" +
                        "        \"diameter\": {\n" +
                        "            \"meters\": 3.7,\n" +
                        "            \"feet\": 12\n" +
                        "        },\n" +
                        "        \"mass\": {\n" +
                        "            \"kg\": 549054,\n" +
                        "            \"lb\": 1207920\n" +
                        "        },\n" +
                        "        \"first_stage\": {\n" +
                        "            \"thrust_sea_level\": {\n" +
                        "                \"kN\": 7607,\n" +
                        "                \"lbf\": 1710000\n" +
                        "            },\n" +
                        "            \"thrust_vacuum\": {\n" +
                        "                \"kN\": 8227,\n" +
                        "                \"lbf\": 1849500\n" +
                        "            },\n" +
                        "            \"reusable\": true,\n" +
                        "            \"engines\": 9,\n" +
                        "            \"fuel_amount_tons\": 385,\n" +
                        "            \"burn_time_sec\": 162\n" +
                        "        },\n" +
                        "        \"second_stage\": {\n" +
                        "            \"thrust\": {\n" +
                        "                \"kN\": 934,\n" +
                        "                \"lbf\": 210000\n" +
                        "            },\n" +
                        "            \"payloads\": {\n" +
                        "                \"composite_fairing\": {\n" +
                        "                    \"height\": {\n" +
                        "                        \"meters\": 13.1,\n" +
                        "                        \"feet\": 43\n" +
                        "                    },\n" +
                        "                    \"diameter\": {\n" +
                        "                        \"meters\": 5.2,\n" +
                        "                        \"feet\": 17.1\n" +
                        "                    }\n" +
                        "                },\n" +
                        "                \"option_1\": \"dragon\"\n" +
                        "            },\n" +
                        "            \"reusable\": false,\n" +
                        "            \"engines\": 1,\n" +
                        "            \"fuel_amount_tons\": 90,\n" +
                        "            \"burn_time_sec\": 397\n" +
                        "        },\n" +
                        "        \"engines\": {\n" +
                        "            \"isp\": {\n" +
                        "                \"sea_level\": 288,\n" +
                        "                \"vacuum\": 312\n" +
                        "            },\n" +
                        "            \"thrust_sea_level\": {\n" +
                        "                \"kN\": 845,\n" +
                        "                \"lbf\": 190000\n" +
                        "            },\n" +
                        "            \"thrust_vacuum\": {\n" +
                        "                \"kN\": 914,\n" +
                        "                \"lbf\": 205500\n" +
                        "            },\n" +
                        "            \"number\": 9,\n" +
                        "            \"type\": \"merlin\",\n" +
                        "            \"version\": \"1D+\",\n" +
                        "            \"layout\": \"octaweb\",\n" +
                        "            \"engine_loss_max\": 2,\n" +
                        "            \"propellant_1\": \"liquid oxygen\",\n" +
                        "            \"propellant_2\": \"RP-1 kerosene\",\n" +
                        "            \"thrust_to_weight\": 180.1\n" +
                        "        },\n" +
                        "        \"landing_legs\": {\n" +
                        "            \"number\": 4,\n" +
                        "            \"material\": \"carbon fiber\"\n" +
                        "        },\n" +
                        "        \"payload_weights\": [\n" +
                        "            {\n" +
                        "                \"id\": \"leo\",\n" +
                        "                \"name\": \"Low Earth Orbit\",\n" +
                        "                \"kg\": 22800,\n" +
                        "                \"lb\": 50265\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": \"gto\",\n" +
                        "                \"name\": \"Geosynchronous Transfer Orbit\",\n" +
                        "                \"kg\": 8300,\n" +
                        "                \"lb\": 18300\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": \"mars\",\n" +
                        "                \"name\": \"Mars Orbit\",\n" +
                        "                \"kg\": 4020,\n" +
                        "                \"lb\": 8860\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"flickr_images\": [\n" +
                        "            \"https://farm1.staticflickr.com/929/28787338307_3453a11a77_b.jpg\",\n" +
                        "            \"https://farm4.staticflickr.com/3955/32915197674_eee74d81bb_b.jpg\",\n" +
                        "            \"https://farm1.staticflickr.com/293/32312415025_6841e30bf1_b.jpg\",\n" +
                        "            \"https://farm1.staticflickr.com/623/23660653516_5b6cb301d1_b.jpg\",\n" +
                        "            \"https://farm6.staticflickr.com/5518/31579784413_d853331601_b.jpg\",\n" +
                        "            \"https://farm1.staticflickr.com/745/32394687645_a9c54a34ef_b.jpg\"\n" +
                        "        ],\n" +
                        "        \"name\": \"Falcon 9\",\n" +
                        "        \"type\": \"rocket\",\n" +
                        "        \"active\": true,\n" +
                        "        \"stages\": 2,\n" +
                        "        \"boosters\": 0,\n" +
                        "        \"cost_per_launch\": 50000000,\n" +
                        "        \"success_rate_pct\": 98,\n" +
                        "        \"first_flight\": \"2010-06-04\",\n" +
                        "        \"country\": \"United States\",\n" +
                        "        \"company\": \"SpaceX\",\n" +
                        "        \"wikipedia\": \"https://en.wikipedia.org/wiki/Falcon_9\",\n" +
                        "        \"description\": \"Falcon 9 is a two-stage rocket designed and manufactured by SpaceX for the reliable and safe transport of satellites and the Dragon spacecraft into orbit.\",\n" +
                        "        \"id\": \"5e9d0d95eda69973a809d1ec\"\n" +
                        "    }"
            )!!
            val rocket3: Rocket = moshi.adapter(Rocket::class.java).fromJson(
                "{\n" +
                        "        \"height\": {\n" +
                        "            \"meters\": 70,\n" +
                        "            \"feet\": 229.6\n" +
                        "        },\n" +
                        "        \"diameter\": {\n" +
                        "            \"meters\": 12.2,\n" +
                        "            \"feet\": 39.9\n" +
                        "        },\n" +
                        "        \"mass\": {\n" +
                        "            \"kg\": 1420788,\n" +
                        "            \"lb\": 3125735\n" +
                        "        },\n" +
                        "        \"first_stage\": {\n" +
                        "            \"thrust_sea_level\": {\n" +
                        "                \"kN\": 22819,\n" +
                        "                \"lbf\": 5130000\n" +
                        "            },\n" +
                        "            \"thrust_vacuum\": {\n" +
                        "                \"kN\": 24681,\n" +
                        "                \"lbf\": 5548500\n" +
                        "            },\n" +
                        "            \"reusable\": true,\n" +
                        "            \"engines\": 27,\n" +
                        "            \"fuel_amount_tons\": 1155,\n" +
                        "            \"burn_time_sec\": 162\n" +
                        "        },\n" +
                        "        \"second_stage\": {\n" +
                        "            \"thrust\": {\n" +
                        "                \"kN\": 934,\n" +
                        "                \"lbf\": 210000\n" +
                        "            },\n" +
                        "            \"payloads\": {\n" +
                        "                \"composite_fairing\": {\n" +
                        "                    \"height\": {\n" +
                        "                        \"meters\": 13.1,\n" +
                        "                        \"feet\": 43\n" +
                        "                    },\n" +
                        "                    \"diameter\": {\n" +
                        "                        \"meters\": 5.2,\n" +
                        "                        \"feet\": 17.1\n" +
                        "                    }\n" +
                        "                },\n" +
                        "                \"option_1\": \"dragon\"\n" +
                        "            },\n" +
                        "            \"reusable\": false,\n" +
                        "            \"engines\": 1,\n" +
                        "            \"fuel_amount_tons\": 90,\n" +
                        "            \"burn_time_sec\": 397\n" +
                        "        },\n" +
                        "        \"engines\": {\n" +
                        "            \"isp\": {\n" +
                        "                \"sea_level\": 288,\n" +
                        "                \"vacuum\": 312\n" +
                        "            },\n" +
                        "            \"thrust_sea_level\": {\n" +
                        "                \"kN\": 845,\n" +
                        "                \"lbf\": 190000\n" +
                        "            },\n" +
                        "            \"thrust_vacuum\": {\n" +
                        "                \"kN\": 914,\n" +
                        "                \"lbf\": 205500\n" +
                        "            },\n" +
                        "            \"number\": 27,\n" +
                        "            \"type\": \"merlin\",\n" +
                        "            \"version\": \"1D+\",\n" +
                        "            \"layout\": \"octaweb\",\n" +
                        "            \"engine_loss_max\": 6,\n" +
                        "            \"propellant_1\": \"liquid oxygen\",\n" +
                        "            \"propellant_2\": \"RP-1 kerosene\",\n" +
                        "            \"thrust_to_weight\": 180.1\n" +
                        "        },\n" +
                        "        \"landing_legs\": {\n" +
                        "            \"number\": 12,\n" +
                        "            \"material\": \"carbon fiber\"\n" +
                        "        },\n" +
                        "        \"payload_weights\": [\n" +
                        "            {\n" +
                        "                \"id\": \"leo\",\n" +
                        "                \"name\": \"Low Earth Orbit\",\n" +
                        "                \"kg\": 63800,\n" +
                        "                \"lb\": 140660\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": \"gto\",\n" +
                        "                \"name\": \"Geosynchronous Transfer Orbit\",\n" +
                        "                \"kg\": 26700,\n" +
                        "                \"lb\": 58860\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": \"mars\",\n" +
                        "                \"name\": \"Mars Orbit\",\n" +
                        "                \"kg\": 16800,\n" +
                        "                \"lb\": 37040\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": \"pluto\",\n" +
                        "                \"name\": \"Pluto Orbit\",\n" +
                        "                \"kg\": 3500,\n" +
                        "                \"lb\": 7720\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"flickr_images\": [\n" +
                        "            \"https://farm5.staticflickr.com/4599/38583829295_581f34dd84_b.jpg\",\n" +
                        "            \"https://farm5.staticflickr.com/4645/38583830575_3f0f7215e6_b.jpg\",\n" +
                        "            \"https://farm5.staticflickr.com/4696/40126460511_b15bf84c85_b.jpg\",\n" +
                        "            \"https://farm5.staticflickr.com/4711/40126461411_aabc643fd8_b.jpg\"\n" +
                        "        ],\n" +
                        "        \"name\": \"Falcon Heavy\",\n" +
                        "        \"type\": \"rocket\",\n" +
                        "        \"active\": true,\n" +
                        "        \"stages\": 2,\n" +
                        "        \"boosters\": 2,\n" +
                        "        \"cost_per_launch\": 90000000,\n" +
                        "        \"success_rate_pct\": 100,\n" +
                        "        \"first_flight\": \"2018-02-06\",\n" +
                        "        \"country\": \"United States\",\n" +
                        "        \"company\": \"SpaceX\",\n" +
                        "        \"wikipedia\": \"https://en.wikipedia.org/wiki/Falcon_Heavy\",\n" +
                        "        \"description\": \"With the ability to lift into orbit over 54 metric tons (119,000 lb)--a mass equivalent to a 737 jetliner loaded with passengers, crew, luggage and fuel--Falcon Heavy can lift more than twice the payload of the next closest operational vehicle, the Delta IV Heavy, at one-third the cost.\",\n" +
                        "        \"id\": \"5e9d0d95eda69974db09d1ed\"\n" +
                        "    }"
            )!!
            return listOf(rocket1, rocket2, rocket3)
        }
    }
}