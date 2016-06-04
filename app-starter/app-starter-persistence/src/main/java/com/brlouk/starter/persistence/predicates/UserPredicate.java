package com.brlouk.starter.persistence.predicates;

import org.joda.time.LocalDate;

import com.brlouk.starter.persistence.QUser;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

public class UserPredicate {

	public static Predicate hasAge(int age) {
		QUser user = QUser.user;
		Predicate predicate = user.isNotNull();
		LocalDate localDate = new LocalDate();
		LocalDate minusYears = localDate.minusYears(age);
		return ((BooleanExpression) predicate).and(user.birthDate.loe(minusYears.toDate()));
	}
}
