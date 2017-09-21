package org.otherTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName IdentificationCodeUtil
 * @Description 身份证验证工具
 * @author houzw
 * @Date 2016年12月26日 下午5:55:30
 * @version 1.0.0
 */
public class IdentificationCodeUtil {

	public static final int IDENTITYCODE_OLD = 15; // 老身份证15位
	public static final int IDENTITYCODE_NEW = 18; // 新身份证18位
	public static int[] Wi = new int[17];

	/**
	 * 判断身份证号码是否正确。
	 * 
	 * @param code
	 *            身份证号码。
	 * @return 如果身份证号码正确，则返回true，否则返回false。
	 */
	public static boolean isIdentityCode(String code) {
//		if (StringUtils.isEmpty(code)) {
//			return false;
//		}
		String birthDay = "";
		code = code.trim();
		// 长度只有15和18两种情况
		if ((code.length() != IDENTITYCODE_OLD)
				&& (code.length() != IDENTITYCODE_NEW)) {
			return false;
		}
		// 身份证号码必须为数字(18位的新身份证最后一位可以是x)
		Pattern pt = Pattern.compile("\\d{15,17}([\\dxX]{1})?");
		Matcher mt = pt.matcher(code);
		if (!mt.find()) {
			return false;
		}
		// 验证生日
		if (code.length() == IDENTITYCODE_OLD) {
			birthDay = "19" + code.substring(6, 12);
		} else {
			birthDay = code.substring(6, 14);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		simpleDateFormat.setLenient(false);
		try {
			simpleDateFormat.format(simpleDateFormat.parse(birthDay));
		} catch (Exception e) {
			return false;
		}
		// if (!TimeUtils.isRightDate(birthDay, "yyyyMMdd")) {
		// return false;
		// }
		// 最后一位校验码验证
		if (code.length() == IDENTITYCODE_NEW) {
			String lastNum = getVerify(code.substring(0, IDENTITYCODE_NEW - 1));
			// check last digit
			if (!("" + code.charAt(IDENTITYCODE_NEW - 1)).toUpperCase().equals(
					lastNum)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取新身份证的最后一位:检验位
	 * 
	 * @param code
	 *            18位身份证的前17位
	 * @return 新身份证的最后一位
	 */
	private static String getCheckFlag(String code) {
		int[] varArray = new int[code.length()];
		String lastNum = "";
		int numSum = 0;
		// 初始化位权值
		setWiBuffer();
		for (int i = 0; i < code.length(); i++) {
			// varArray[i] = NumberUtil.toInt("" + code.charAt(i));
			varArray[i] = code.charAt(i);
			varArray[i] = varArray[i] * Wi[i];
			numSum = numSum + varArray[i];
		}
		int checkDigit = 12 - numSum % 11;
		switch (checkDigit) {
		case 10:
			lastNum = "X";
			break;
		case 11:
			lastNum = "0";
			break;
		case 12:
			lastNum = "1";
			break;
		default:
			lastNum = String.valueOf(checkDigit);
		}
		return lastNum;
	}

	/**
	 * @param eightcardid
	 * @return
	 */
	public static String getVerify(String eightcardid) {
		int remaining = 0;
		int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
		int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
		int[] ai = new int[18];
		String returnStr = null;
		try {
			if (eightcardid.length() == 18) {
				eightcardid = eightcardid.substring(0, 17);
			}
			if (eightcardid.length() == 17) {
				int sum = 0;
				String k = null;
				for (int i = 0; i < 17; i++) {
					k = eightcardid.substring(i, i + 1);
					ai[i] = Integer.parseInt(k);
					k = null;
				}
				for (int i = 0; i < 17; i++) {
					sum = sum + wi[i] * ai[i];
				}
				remaining = sum % 11;
			}
			returnStr = remaining == 2 ? "X" : String.valueOf(vi[remaining]);
		} catch (Exception ex) {
			return null;
		} finally {
			wi = null;
			vi = null;
			ai = null;
		}
		return returnStr;
	}

	/**
	 * 初始化位权值
	 */
	private static void setWiBuffer() {
		for (int i = 0; i < Wi.length; i++) {
			int k = (int) Math.pow(2, (Wi.length - i));
			Wi[i] = k % 11;
		}
	}

	/**
	 * 判别是否字符串为null或者没有内容，或者全部为空格。
	 */
	public static boolean empty(String o) {
		return ((null == o) || (o.length() <= 0) || (o.trim().equals("")));
	}

	/**
	 * 将15位身份证号码升级为18位身份证号码
	 * 
	 * @param code
	 *            15位身份证号码
	 * @return 18位身份证号码
	 */
	public static String update2eighteen(String code) {
//		if (StringUtils.isEmpty(code)) {
//			return "";
//		}
		code = code.trim();
		if (code.length() != IDENTITYCODE_OLD || !isIdentityCode(code)) {
			return "";
		}
		code = code.substring(0, 6) + "19" + code.substring(6);
		//
		code = code + getCheckFlag(code);
		return code;
	}

	/**
	 * 15位身份证号码转化为18位的身份证。如果是18位的身份证则直接返回，不作任何变化。
	 * 
	 * @param idCard
	 *            ,15位的有效身份证号码
	 * @return idCard18 返回18位的有效身份证
	 */
	public static String IdCard15to18(String idCard) {
		idCard = idCard.trim();
		StringBuffer idCard18 = new StringBuffer(idCard);
		// 加权因子
		// int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		// 校验码值
		char[] checkBit = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3',
				'2' };
		int sum = 0;
		// 15位的身份证
		if (idCard != null && idCard.length() == 15) {
			idCard18.insert(6, "19");
			for (int index = 0; index < idCard18.length(); index++) {
				char c = idCard18.charAt(index);
				int ai = Integer.parseInt(new Character(c).toString());
				// sum = sum+ai*weight[index];
				// 加权因子的算法
				int Wi = ((int) Math.pow(2, idCard18.length() - index)) % 11;
				sum = sum + ai * Wi;
			}
			int indexOfCheckBit = sum % 11; // 取模
			idCard18.append(checkBit[indexOfCheckBit]);
		}
		return idCard18.toString();
	}

	/**
	 * 转化18位身份证位15位身份证。如果输入的是15位的身份证则不做任何转化，直接返回。
	 * 
	 * @param idCard
	 *            18位身份证号码
	 * @return idCard15
	 */
	public String IdCard18to15(String idCard) {
		idCard = idCard.trim();
		StringBuffer idCard15 = new StringBuffer(idCard);
		if (idCard != null && idCard.length() == 18) {
			idCard15.delete(17, 18);
			idCard15.delete(6, 8);
		}
		return idCard15.toString();

	}

	/**
	 * 通过身份证获取用户年龄
	 * 
	 * @param idCard
	 *            身份证号
	 * @return 异常返回-1
	 */
	public static Integer getAgeByIdCard(String idCard) {
		// 校验身份证
		if (!isIdentityCode(idCard))
			return -1;

		String birthDay = null;
		if (idCard.length() == IDENTITYCODE_OLD) {
			birthDay = "19" + idCard.substring(6, 12);
		} else {
			birthDay = idCard.substring(6, 14);
		}

		int age = getAgeFromBirthTime(birthDay);

		return age;

	}

	/**
	 * 根据年月日计算年龄
	 * 
	 * @param birthTimeString
	 *            yyyyMMdd
	 * @return 异常返回 -1
	 */
	public static int getAgeFromBirthTime(String birthTimeString) {

		// 校验字符格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		simpleDateFormat.setLenient(false);
		try {
			simpleDateFormat.format(simpleDateFormat.parse(birthTimeString));
		} catch (Exception e) {
			return -1;
		}

		// 先截取到字符串中的年、月、日
		String year = birthTimeString.substring(0, 4);
		String month = birthTimeString.substring(4, 6);
		String day = birthTimeString.substring(6, birthTimeString.length());

		int selectYear = Integer.parseInt(year);
		int selectMonth = Integer.parseInt(month);
		int selectDay = Integer.parseInt(day);
		// 得到当前时间的年、月、日
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayNow = cal.get(Calendar.DATE);

		// 用当前年月日减去生日年月日
		int yearMinus = yearNow - selectYear;
		int monthMinus = monthNow - selectMonth;
		int dayMinus = dayNow - selectDay;

		int age = yearMinus;// 先大致赋值
		if (yearMinus < 0) {// 选了未来的年份
			age = 0;
		} else if (yearMinus == 0) {// 同年的，要么为1，要么为0
			if (monthMinus < 0) {// 选了未来的月份
				age = 0;
			} else if (monthMinus == 0) {// 同月份的
				if (dayMinus < 0) {// 选了未来的日期
					age = 0;
				} else if (dayMinus >= 0) {
					age = 1;
				}
			} else if (monthMinus > 0) {
				age = 1;
			}
		} else if (yearMinus > 0) {
			if (monthMinus < 0) {// 当前月>生日月
			} else if (monthMinus == 0) {// 同月份的，再根据日期计算年龄
				if (dayMinus < 0) {
				} else if (dayMinus >= 0) {
					age = age + 1;
				}
			} else if (monthMinus > 0) {
				age = age + 1;
			}
		}
		
		// 刚出生时及其之后生日之前是0岁
		age = (age - 1) < 0 ? 0 : --age;
		
		return age;
	}

	/**
	 * 通过身份证获取性别
	 * 
	 * @param idCard
	 * @return 0=女|1=男|-1=异常
	 */
	public static Integer getSexualFromidCard(String idCard) {
		
		// 校验身份证
		if (!isIdentityCode(idCard))
			return -1;
		String usex = null;
		if(idCard.length() == IDENTITYCODE_OLD){
			usex = idCard.substring(14, 15);
		}else{
			usex = idCard.substring(16).substring(0, 1);
		}
		
		// 单数为男，偶数为女
		return Integer.parseInt(usex) % 2;
		
//		 if (Integer.parseInt(usex) % 2 == 0) {  
//	            return 0; 
//	        } else {  
//	        	return 1;  
//	        }  

	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		String idCard = "610822199504093922";// 异常
//		String idCard = "510681199510123759";

//		String idCard = "130901201603175631";
		//652822201707227619
		//441324201510234837
		//130901201603175631
		
//		String idCard = "34020320170720623X";
//		String idCard = "652822201707227619";
//		String idCard = "500227201607203470";
		String idCard = "430703201607221298";
		
		
		

		Integer age = IdentificationCodeUtil.getAgeByIdCard(idCard);
		Integer sex = IdentificationCodeUtil.getSexualFromidCard(idCard);
		System.out.println("age:"+age);
		System.out.println("sex:"+sex);
	}
}
