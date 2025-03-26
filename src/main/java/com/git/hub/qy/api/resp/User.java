package com.git.hub.qy.api.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String ID;
    private String name;
    private String userName;
    private String password;
}
