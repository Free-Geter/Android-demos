package com.example.myfirstapplication.SQLite;

public final class ContactContract {

    private ContactContract(){}

    public static class ContactEntry{
        public static final String TABLE_NAME = "contact_name";
        public static final String CONTACT_ID = "contact_id";
        public static final String NAME = "name";
        public static final String EMAIL = "e-mail";
    }

}
