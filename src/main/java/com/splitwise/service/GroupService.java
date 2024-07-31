package com.splitwise.service;

import com.splitwise.dto.request.GroupRequestDTO;
import com.splitwise.dto.response.ApiResponse;
import com.splitwise.entity.Group;

public interface GroupService {
    ApiResponse<Object> createGroup(GroupRequestDTO groupRequestDTO);
    ApiResponse<Object> deleteGroup(String groupId);
    ApiResponse<Object> addUserToGroup(String groupId,String userId);
    ApiResponse<Object> removeUserFromGroup(String groupId,String userId);
    ApiResponse<Object> getGroupMembers(String groupId);
    Group findById(String id);
    ApiResponse<Object> getGroupExpenses(String groupId);
}
