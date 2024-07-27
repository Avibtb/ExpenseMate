package com.splitwise.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permissions {

    GROUP_READ_EXPENSE,
    GROUP_ADD_EXPENSE,
    GROUP_REMOVE_USER,
    GROUP_ADD_USER,
    GROUP_READ_USERS,
    GROUP_DELETE;

    public String withObjectId(String objectId){
        return this.name() + "_" +  objectId;
    }
}
