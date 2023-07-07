package vidal.falcon.ef.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vidal.falcon.ef.entities.ClvfMember;
import vidal.falcon.ef.entities.ClvfPayment;
import vidal.falcon.ef.repositories.ClvfMemberRepository;
import vidal.falcon.ef.repositories.ClvfPaymentRepository;
import vidal.falcon.ef.services.ClvfPaymentService;

@Service
public class ClvfPaymentServiceImpl implements ClvfPaymentService {
    @Autowired
    ClvfMemberRepository clvfMemberRepository;

    @Autowired
    ClvfPaymentRepository clvfPaymentRepository;

    @Override
    public ClvfPayment clvfSave(ClvfPayment clvfPayment) {
        ClvfMember clvfMemberFound = clvfMemberRepository.findById(clvfPayment.getClvfMember().getId()).get();

        ClvfPayment newClvfPayment = new ClvfPayment(
                clvfPayment.getClvfMonth(),
                clvfPayment.getClvfMonth(),
                clvfPayment.getClvfAmount(),
                clvfPayment.isClvfStatus(),
                clvfMemberFound
            );

        ClvfPayment savedClvfPayment = clvfPaymentRepository.save(newClvfPayment);
        savedClvfPayment.getClvfMember().setClvfPayments(null);
        return savedClvfPayment;
    }
}
