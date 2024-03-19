package org.example.controller;

import org.example.api.UserApi;
import org.example.domain.User;
import org.example.services.MyService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;

import java.util.Set;

public class UserController extends SelectorComposer<Component> {
    MyService myService;
    @Wire
    private Listbox userList;
    private UserApi userApi;
    @Init
    public void init() {
        // Fetch users on initialization
        Set<User> users = userApi.getAllUsers();
        // Update the listbox using loop
        if(users != null) {
            for(User user: users) {
                //Add user data to listbox
                userList.appendItem(user.getClass().getName(), userList.getName());
            }
        }
    }


}
