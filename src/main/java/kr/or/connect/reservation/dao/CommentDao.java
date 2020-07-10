package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CommentDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserComment;

@Repository
public class CommentDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);

    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservationUserComment")
                .usingGeneratedKeyColumns("id");
    }

	public List<ReservationUserComment> getComments(Integer productId, Integer start, Integer limit) {
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_COMMENTS, params, rowMapper);
	}

	public int getCount(Integer productId) {
		Map<String,?> params = Collections.singletonMap("productId", productId);
		return jdbc.queryForObject(COUNT, params, Integer.class);
	}

	public int getAvgScore(int id) {
		Map<String,?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(AVG_SCORE, params, Integer.class);
	}

}
