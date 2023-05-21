package com.wonsi.statrip.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowCntDto {
    int followingCnt;
    int followerCnt;

    public FollowCntDto(int followingCnt, int followerCnt) {
        this.followingCnt = followingCnt;
        this.followerCnt = followerCnt;
    }

    public FollowCntDto() {
    }
}
