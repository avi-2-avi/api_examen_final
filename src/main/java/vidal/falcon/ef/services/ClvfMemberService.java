package vidal.falcon.ef.services;

import vidal.falcon.ef.entities.ClvfMember;

public interface ClvfMemberService {
    public ClvfMember clvfSave(ClvfMember clvfMember);
    public Integer clvfGetPaymentCount(String clvfMonth);
}
