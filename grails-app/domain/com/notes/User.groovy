package com.notes

class User {

    String id
    String name
    String email
    String password
    String avatar
    Date createdAt
    Date updatedAt

    static mapping = {
        table 'users'
    }

    static constraints = {
    }
}
