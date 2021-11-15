package com.tecbabel.alammall.modal

class Orders {

    var id_user : Int
    var jumlah : Int
    var cacatan : String
    var nama_product : String

    constructor(id_user: Int, jumlah: Int, cacatan: String, nama_product: String) {
        this.id_user = id_user
        this.jumlah = jumlah
        this.cacatan = cacatan
        this.nama_product = nama_product
    }
}