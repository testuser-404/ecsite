package jp.co.internous.ecsite.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.ecsite.model.domain.MstGoods;
import jp.co.internous.ecsite.model.domain.MstUser;
import jp.co.internous.ecsite.model.form.LoginForm;

@Mapper
public interface MstGoodsMapper {

	@Select(value = "SELECT * FROM mst_goods")
		List<MstGoods> findAll();
		MstUser findByUserNameAndPassword(LoginForm form);
		
		@Insert("INSERT INTO mst_goods (goods_name,price) VALUES (#{goodsName},#{price})")
		@Options(useGeneratedKeys=true,keyProperty="id")
		int insert(MstGoods goods);
		
		@Update("DELETE FROM mst_goods WHERE id = #{id}")
		int deleteById(int id);
}

