package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInfoPrice;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	private RowMapper<ReservationInfoPrice> rowMapperPrice = BeanPropertyRowMapper.newInstance(ReservationInfoPrice.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}
	
	public int reservationRegister(Reservation reservation) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public ReservationInfo getReservationInfos(int reservationInfoId) {
		Map<String,?> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		return jdbc.queryForObject(SELECT_ALL_RESERVATIONINFO, params, rowMapper);
	}

	public List<ReservationInfoPrice> getPrices(int reservationInfoId) {
		Map<String,?> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		return jdbc.query(SELECT_RESERVATIONINFO_PRICE, params, rowMapperPrice);
	}

}
