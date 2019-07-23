package com.github.sejoung.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "TB_RESERVATION")
public class Reservation extends AbstractTimeEntity {

	@Id
	@EmbeddedId
	private ReservationKey key;

	@OneToOne
	private User user;

	@Builder
	private Reservation(ReservationKey key, User user) {
		this.key = key;
		this.user = user;
	}
}
