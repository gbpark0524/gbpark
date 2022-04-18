package kr.pe.gbpark.main.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class ToMeRepositoryImpl implements ToMeRepositoryCustom{
	private final JPAQueryFactory queryFactory;

	public ToMeRepositoryImpl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
}
