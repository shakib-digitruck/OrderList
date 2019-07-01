package com.example.orderlist.models

import java.sql.Date
import java.sql.Time

data class Order(
    var comapany_name: String,
    var pickup: String,
    var destination_company: String,
    var dropoff: String,
    var bigTruck: Int,
    var smallTruck: Int,
    var date: Date,
    var time: Time)

object Supplier {

    val orderlist = arrayOf(
        Order(
            "DigiTruck Logistics Ltd.",
            "Mirpur DOHS, Dhaka",
            "Agami Labs",
            "Hathazari, Chittagong",
            10,
            20,
            Date(2019 - 1900, 11, 29),
            Time(12, 30, 0)
        ),
        Order(
            "Bangladesh Computer Council",
            "Agargaon, Dhaka",
            "University of Chittagong",
            "Hathazari, Chittagong",
            20,
            50,
            Date(2019 - 1900, 7, 9),
            Time(10, 0, 0)
        ),
        Order(
            "Ahnaf Trade",
            "Chagolnaiya, Feni",
            "eTruck logistics",
            "Mirpur DOHS, Dhaka",
            10,
            15,
            Date(2019 - 1900, 8, 19),
            Time(17, 0, 0)
        ),
        Order(
            "DigiTruck Logistics Ltd.",
            "Mirpur DOHS, Dhaka",
            "Agami Labs",
            "Hathazari, Chittagong",
            10,
            20,
            Date(2019 - 1900, 11, 29),
            Time(12, 30, 0)
        ),
        Order(
            "Bangladesh Computer Council",
            "Agargaon, Dhaka",
            "University of Chittagong",
            "Hathazari, Chittagong",
            20,
            50,
            Date(2019 - 1900, 7, 9),
            Time(10, 0, 0)
        ),
        Order(
            "DigiTruck Logistics Ltd.",
            "Mirpur DOHS, Dhaka",
            "Agami Labs",
            "Hathazari, Chittagong",
            10,
            20,
            Date(2019 - 1900, 11, 29),
            Time(12, 30, 0)
        ),
        Order(
            "Bangladesh Computer Council",
            "Agargaon, Dhaka",
            "University of Chittagong",
            "Hathazari, Chittagong",
            20,
            50,
            Date(2019 - 1900, 7, 9),
            Time(10, 0, 0)
        ),
        Order(
            "Ahnaf Trade",
            "Chagolnaiya, Feni",
            "eTruck logistics",
            "Mirpur DOHS, Dhaka",
            10,
            15,
            Date(2019 - 1900, 8, 19),
            Time(17, 0, 0)
        )
        )
}
