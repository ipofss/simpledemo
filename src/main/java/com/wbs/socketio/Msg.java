package com.wbs.socketio;

import lombok.Data;

import java.io.Serializable;

/**
 * msg实体
 *
 * @author: wangbingshuai
 * @create: 2020-02-27 20:07
 **/
@Data
public class Msg implements Serializable {
    private String userId;
    private String userName;
    private String receiveUserId;
    private String content;
}
