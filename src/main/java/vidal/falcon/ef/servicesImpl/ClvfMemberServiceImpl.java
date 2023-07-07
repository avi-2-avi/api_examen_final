package vidal.falcon.ef.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vidal.falcon.ef.entities.ClvfMember;
import vidal.falcon.ef.repositories.ClvfMemberRepository;
import vidal.falcon.ef.services.ClvfMemberService;

import java.util.List;

@Service
public class ClvfMemberServiceImpl implements ClvfMemberService {
    @Autowired
    ClvfMemberRepository clvfMemberRepository;

    @Override
    public ClvfMember clvfSave(ClvfMember clvfMember) {
        ClvfMember clvfNewMember = new ClvfMember(clvfMember.getClvfName(), clvfMember.getClvfMemberCode());
        ClvfMember clvfSavedMember = clvfMemberRepository.save(clvfNewMember);
        return clvfSavedMember;
    }

    @Override
    public Integer clvfGetPaymentCount(String clvfMonth) {
        // Get all members
        List<ClvfMember> clvfMembers = clvfMemberRepository.findAll();

        // Filter by members with payments on the given month
        Integer clvfCount = 0;
        for (ClvfMember clvfMember : clvfMembers) {
            for (int i = 0; i < clvfMember.getClvfPayments().size(); i++) {
                if (clvfMember.getClvfPayments().get(i).getClvfMonth().equals(clvfMonth) && !clvfMember.getClvfPayments().get(i).isClvfStatus()) {
                    clvfCount++;
                    break;
                }
            }
        }

        return clvfCount;
    }
}
