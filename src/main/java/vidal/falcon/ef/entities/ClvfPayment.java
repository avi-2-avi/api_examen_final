package vidal.falcon.ef.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clvf_payments")
@Data
@NoArgsConstructor
public class ClvfPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clvfMonth;
    private String clvfYear;
    private Double clvfAmount;
    private boolean clvfStatus;

    @ManyToOne
    @JoinColumn(name="clvf_member_id")
    private ClvfMember clvfMember;

    public ClvfPayment(String clvfMonth, String clvfYear, Double clvfAmount, boolean clvfStatus, ClvfMember clvfMember) {
        this.clvfMonth = clvfMonth;
        this.clvfYear = clvfYear;
        this.clvfAmount = clvfAmount;
        this.clvfStatus = clvfStatus;
        this.clvfMember = clvfMember;
    }
}
