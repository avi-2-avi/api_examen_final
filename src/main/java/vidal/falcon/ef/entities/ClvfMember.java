package vidal.falcon.ef.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="clvf_members")
@Data
@NoArgsConstructor
public class ClvfMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clvfName;
    private Long clvfMemberCode;

    @OneToMany(mappedBy = "clvfMember")
    private List<ClvfPayment> clvfPayments;

    public ClvfMember(String clvfName, Long clvfMemberCode) {
        this.clvfName = clvfName;
        this.clvfMemberCode = clvfMemberCode;
    }
}
