package vidal.falcon.ef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vidal.falcon.ef.entities.ClvfMember;

public interface ClvfMemberRepository extends JpaRepository<ClvfMember, Long> {
}
