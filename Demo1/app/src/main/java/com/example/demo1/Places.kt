package com.example.demo1

class Places {
    var img = 0
    var title = ""
    var date = ""

    constructor(img: Any, title: String, date: String) {
        this.img = img as Int
        this.title = title
        this.date = date
    }
}