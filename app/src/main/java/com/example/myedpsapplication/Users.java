package com.example.myedpsapplication;

public class Users {

    String name;

    public Users() {
        // デフォルトコンストラクタはデータのデシリアライズ時にFirebaseが必要とするため、空のままにします。
    }

    public Users(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // nameプロパティのセッター
    public void setName(String name) {
        this.name = name;
    }

}
