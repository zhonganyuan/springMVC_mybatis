package com.wkb.common.util;

import javax.servlet.ServletContext;

/**
 * 系统常量
 * 
 * @author huanglt
 * 
 */
public final class Constant {
	
	// 系统session信息编码
	public static final class SessionType {
		// 验证码
		public static final String CHECK_VALID_CODE = "check_valid_code";
		// 登陆用户信息
		public static final String USER_LOGIN_INFO = "user_login_info";
		// 登陆用户客户端信息
		public static final String USER_CLIENT_INFO = "user_client_info";
		//平台用户信息
		public static final String USER_LOGIN_INFO_NEW="user_login_info_new";
		//平台用户信息
		public static final String PASSPORT_LOGIN_INFO="passport_login_info";
		//登录用户权限信息
		public static final String USER_AUTHORITY_INFO="user_authority_info";
	}

	// 登陆用户信息
	public static final class ClientInfo {
		// 登陆用户远程IP
		public static final String CLIENT_ADDR = "client_addr";
	}

	// 用户信息
	public static final class User {
		//保密
		public static final Byte CB_SEX_SECRET = 2;
		// 用户类型：商户
		public static final Byte ACCOUNT_USER_TYPE_MERCHANT = 1;
		// 用户类型：用户
		public static final Byte ACCOUNT_USER_TYPE_USER = 2;
		// 用户类型：供应商
		public static final Byte ACCOUNT_USER_TYPE_SUPPLIER = 3;
		// 悟空保邮箱
		public static final String WKB_EMAI = "msgmaster@wkbins.com";
		// 密码正则
		public static final String USER_PASSWORD_REGEX = "(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,}";
		// 邮箱正则
		public static final String USER_EMAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		// 邮箱或手机号正则
		public static final String USER_EMAIL_OR_Phone_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}|((0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8})$";
	
		// 账户状态
		public static final Byte ACCOUNT_STATUS_STOP = 0; //停用
		public static final Byte ACCOUNT_STATUS_NORMAL = 1; //正常
		public static final Byte ACCOUNT_NO_ACTIVE = 2; //未激活
		
		//年收入类型
		public static final Byte ANNUAL_INCOME_1 = 1; //5万以下
		public static final Byte ANNUAL_INCOME_2 = 2; //5-10万元
		public static final Byte ANNUAL_INCOME_3 = 3; //10-50万元
		public static final Byte ANNUAL_INCOME_4 = 4; //50万以上
	}
	
	// 商户信息
	public static final class Merchant {
		// 商户状态  0:终止;1:生效;2:审核失败;3:待审核
		public static final Byte MERCHANT_STATUS_0 = 0;
		public static final Byte MERCHANT_STATUS_1 = 1;
		public static final Byte MERCHANT_STATUS_2 = 2;
		public static final Byte MERCHANT_STATUS_3 = 3;
		
		//是否同意接受审核通知短信
		public static final Byte AGREE_AUDIT_MESSAGE = 1;
		public static final Byte DISAGREE_AUDIT_MESSAGE = 0;
		
		//充值方式
		//银行转账
		public static final String UBPAYTYPE_BANK = "10";
		//支票
		public static final String UBPAYTYPE_CHECK = "11";
		//柜台
		public static final String UBPAYTYPE_COUNTER = "12";
		//其他
		public static final String UBPAYTYPE_OTHER = "13";
		//商户线下投保模板最末一级标题起始行，下一行即为投保信息
		public static final Byte TEMPLATE_TITLE_END_ROW = 5;
		//模板，投保人信息前缀
		public static final String POLICYHOLDER_PREFIX = "toubao_";
		//模板，被保人信息前缀
	    public static final String INSURED_PREFIX = "beibao_";
	    //模板，受益人信息前缀
	    public static final String BENEFICIARY_PREFIX = "shouyi_";
	    //线下投保，批次号，投保时组织JSON时的key
	    public static final String BATCH_NO = "batchNo";
	    //列类型标志key
	    public static final String TYPE_KEY = "type";
	    //下拉框标志
	    public static final String SELECT_KEY = "select";
	    //时间
	    public static final String TIME_KEY = "time";
	    //线下投保：0:上传失败,1:上传成功（待处理）,2:已处理
	    public static final int INSURANCE_STATUS_FAIL = 0;
	    public static final int INSURANCE_STATUS_SUCCESS = 1;
	    public static final int INSURANCE_STATUS_DISPOSED = 2;
	}
	
	public static final class Supplier {
		//供应商标识
		public static final String SUPPLIER_ID = "supplier";
		//供应商类型--保险公司
		public static final byte TYPE_INSURANCE_COMPANY = 1;
		//供应商类型--服务商
		public static final byte TYPE_SERVICE_PROVIDER = 2;
		
		//停用
		public static final byte STATUS_DISABLED = 0;
		//启用
		public static final byte STATUS_ENABLED = 1;
		
	}

	// 续保状态
	public static final class RENEWAL_STATUS {
		// 无需续保
		public static final byte RENEWAL_NO = 0;
		// 需要续保但是尚未续保
		public static final byte INSURANCE_YES_HAVENOTDONE = 1;
		// 需要续保并且已经续保
		public static final byte INSURANCE_YES_DONE = 2;
		// 投保结束
	    public static final byte INSURANCE_DONE = 3;
	}
	
	// 上传文件存放key
	public static final class UploadInfo {
		// 上传文件对象信息
		public static final String ATTACHMENTS = "attachments";
		// 上传文件对象信息（单个）
		public static final String ATTACHMENT = "attachment";
		// 上传文件编码
		public static final String ATTCODES = "attcodes";
		// 上传文件编码（单个）
		public static final String ATTCODE = "attcode";
		// 分inputname记录编码
		public static final String MULTI_ATTCODES = "multi_attcodes";
	}

	// 保额类型
	public static final class AmountInsuredType {
		// 定额
		public static final Byte QUOTA = 1;
		// 公式
		public static final Byte FORMULA = 2;
	}
	
	// 保费类型
	public static final class AmountPremiumType {
		// 定额
		public static final Byte QUOTA = 0;
		//商户传入
		public static final Byte KEY = 1;
		// 公式
		public static final Byte FORMULA = 2;
	}

	// 保险费率取值类型
	public static final class ValueType {
		// 订单交易额
		public static final Byte ORDER_VOLUME = 1;
	}

	// 保险费率运算符号
	public static final class ScaleType {
		// 加
		public static final Byte ADDITION = 1;
		// 减
		public static final Byte SUBTRATION = 2;
		// 乘
		public static final Byte MULTIPLICATION = 3;
		// 除
		public static final Byte DIVISION = 4;
	}

	// 保险管理角色配置
	public static final class InsuranceRole {
		// 悟空保
		public static final Byte INSURANCE_ROLE_WKB = 1;
		// 用户
		public static final Byte INSURANCE_ROLE_USER = 2;
		// 商家
		public static final Byte INSURANCE_ROLE_MERCHANT = 3;
		// 服务人员
		public static final Byte INSURANCE_SERVICE_STAFF = 4;
	}
	
	// 保险类型
	public static final class InsuranceType {
		// 延误险
		public static final String YANWU = "yanwu";
		// 人身险
		public static final String RENSHEN = "renshen";
		// 其他
		public static final String OTHER = "other";
		//交强险
		public static final Byte INSURANCE_TYPE_JIAOQIANG=0;
		//商业险
		public static final Byte INSURANCE_TYPE_SHANGYE=1;
	}
	
	// 投保人被保人关系
	public static final class HoldInsRelation {
		// 本人
		public static final int SELF = 1;
		// 配偶
		public static final int SPOUSE = 2;
		// 子女
		public static final int CHILDREN = 3;
		// 父母
		public static final int PARENTS = 4;
	}

	// 理赔规则
	public static final class ClaimRules {
		// 自动触发
		public static final Byte CLAIM_RULES_AUTO = 1;
		// 手动触发
		public static final Byte CLAIM_RULES_MANUAL = 2;
	}
	
	// 理赔常量
	public static final class Claim {
		// 理赔编码前缀
		public static final String CLAIM_CODE_PRE = "LP";
		//理赔申请时填写的保险类型
		public static final String CLAIMS_TYPE_PERINJURY = "personAccidentInjury";//人身意外伤害
		public static final String CLAIMS_TYPE_RIGHTDAMAG = "personRightsDamage";//人身权利损害
		public static final String CLAIMS_TYPE_PERSONPROPERT = "personalProperty";//人身财产
	}

	// 订单配置
	public static final class ORDER_KEY {
		// ============订单结果key================
		// 订单编码KEY
		public static final String ORDER_CODE = "ORDER_CODE";
		// 订单用户编码KEY
		public static final String ORDER_USER_CODE = "ORDER_USER_CODE";
		// 订单服务人员编码KEY
		public static final String ORDER_WAITER_CODE = "ORDER_WAITER_CODE";
		// 订单服务供应商KEY
		public static final String ORDER_PROVIDER_CODE = "ORDER_PROVIDER_CODE";
		
		//支付方式
		//线上支付
		public static final byte PAY_WAY_TYPE_ONLINE  =0;
		//线下支付
		public static final byte PAY_WAY_TYPE_OFFLINE =1;
		//
		public static final byte PAY_WAY_TYPE_SELF = 2;
		// 订单支付方式类型
		//无须支付
		public static final String ORDER_PAY_TYPE_0 = "0";
		//支付宝
		public static final String ORDER_PAY_TYPE_1 = "1";
		//微信
		public static final String ORDER_PAY_TYPE_2 = "2";
		//银联
		public static final String ORDER_PAY_TYPE_3 = "3";
		//现金
		public static final String ORDER_PAY_TYPE_4 = "4";
		//会员
		public static final String ORDER_PAY_TYPE_5 = "5";
		//分期
		public static final String ORDER_PAY_TYPE_6 = "6";
		//其它
		public static final String ORDER_PAY_TYPE_7 = "7";
		//代扣
		public static final String ORDER_PAY_TYPE_DK = "8";

		// ===============保单结果KEY============
		// 保单生成KEY
		public static final String POLICY_RESULT_KEY = "POLICY_RESULT_KEY";
		// 保单需要调保险公司接口KEY
		public static final String POLICY_REMOTE_KEY = "POLICY_REMOTE_KEY";
		// 保单金额的数字格式
		public static final String POLICY_NUM_FORMAT = "#.00";

		// 订单内容KEY
		public static final String ORDER_BIZ_CONTENT = "ORDER_BIZ_CONTENT";
		// 商户APPKEY
		public static final String ORDER_CHANNEL_APPKEY = "ORDER_CHANNEL_APPKEY";
		// 商户保险CONFIG KEY
		public static final String ORDER_CONFIG_KEY = "ORDER_CONFIG_KEY";
		// 订单编号KEY
		public static final String ORDER_NO_KEY = "ORDER_NO_KEY";
		// 订单金额（一个订单对应保单之和）
		public static final String ORDER_TOTAL_PREMIUM = "totalPremium";
		// 保单编号KEY
		public static final String POLICY_NO_KEY = "POLICY_NO_KEY";
		// 投保用户KEY
		public static final String POLICY_INSURER_NAME_KEY = "POLICY_INSURER_NAME_KEY";
		// 投保用户手机KEY
		public static final String POLICY_INSURER_PHONE_KEY = "POLICY_INSURER_PHONE_KEY";
		// 投保用户证件类型KEY
		public static final String POLICY_INSURER_ID_TYPE_KEY = "POLICY_INSURER_ID_TYPE_KEY";
		// 投保用户证件信息KEY
		public static final String POLICY_INSURER_ID_INFO_KEY = "POLICY_INSURER_ID_INFO_KEY";
		// 被保用户KEY
		public static final String POLICY_USER_NAME_KEY = "POLICY_USER_NAME_KEY";
		// 被保用户手机KEY
		public static final String POLICY_USER_PHONE_KEY = "POLICY_USER_PHONE_KEY";
		// 被保用户证件类型KEY
		public static final String POLICY_USER_ID_TYPE_KEY = "POLICY_USER_ID_TYPE_KEY";
		//被保用户证件信息
		public static final String POLICY_USER_ID_INFO_KEY = "POLICY_USER_ID_INFO_KEY";

		//订单来源  接口
		public static final String ORDER_RESOURCE_JK = "jk";
		//订单来源  微信
		public static final String ORDER_RESOURCE_WX = "wx";
		
		
		
	}

	// 操作运算符
	public static final class Operation {
		// 加
		public static final String OPERATION_ADD = "add";
		// 减
		public static final String OPERATION_SUBTRACTION = "subtraction";
		// 乘
		public static final String OPERATION_MULT = "mult";
		// 除
		public static final String OPERATION_DIVISION = "division";
	}

	// 保单状态
	public static final class INSURANCE_STATUS {
		// 投保-提交资料
		public static final byte INSURANCE_HANDLE = 1;
		// 撤单
		public static final byte INSURANCE_POLICYBACK = 2;
		// 核保中
		public static final byte INSURANCE_HANDLING = 3;
		// 核保-核保失败
		public static final byte INSURANCE_HANDLE_FAIL = 4;
		// 核保-核保成功
		public static final byte INSURANCE_HANDLE_SUCESS = 5;
		// 承保-承保成功未生效
		public static final byte INSURANCE_HANDLE_ACCEPTANCE = 6;
		// 生效
		public static final byte INSURANCE_HANDLE_EFFECTIVE = 7;
		//理赔-申请理赔
		public static final byte INSURANCE_HANDLE_COMPENSATEREQ = 8;
		//理赔-核赔中
		public static final byte INSURANCE_HANDLE_COMPENSATEREQSUCESS = 9;
		//理赔-拒赔
		public static final byte INSURANCE_HANDLE_COMPENSATEREQREFUSE = 10;
		//理赔-同意理赔
		public static final byte INSURANCE_HANDLE_COMPENSATESUCESS = 11;
		//理赔-待支付理赔金
		public static final byte INSURANCE_HANDLE_COMPENSATEWAITMONEY = 12;
		//终止-理赔终止
		public static final byte INSURANCE_HANDLE_ENDCOMPENSATE = 13;
		//终止-过期终止
		public static final byte INSURANCE_HANDLE_ENDDATE = 14;
		//终止-违约终止
		public static final byte INSURANCE_HANDLE_ENDCONTRACT = 15;
		//终止-投保人解除终止
		public static final byte INSURANCE_HANDLE_ENDCUSTOMER = 16;
		//终止-其他终止
		public static final byte INSURANCE_HANDLE_ENDOTHER = 17;
		// 失效
		public static final byte INSURANCE_HANDLE_INVALID = 18;
		// 关闭
		public static final byte INSURANCE_HANDLE_CLOSED = 19;
	}
	
	//投保方式
	public static final class INSURE_WAY {
		//自营
		public static final byte INSURE_WAY_SELF_SUPPORT = 0;
		//线下
		public static final byte INSURE_WAY_OFFLINE = 1;
		//线上-立即投保
		public static final byte INSURE_WAY_ONLINE = 2;
		//线上-延迟投保
		public static final byte INSURE_WAY_ONLINE_delay = 3;
		//自定义
		public static final byte INSURE_WAY_CUSTOM = 9;
	}

	// 费率是否提交审核
	public static final class isUpdateAudit {
		// 提交
		public static final Byte AUDITCOMMIT = 1;
		// 不提交
		public static final Byte AUDITNO = 0;
	}

	// 产品状态
	public static final class productStatus {
		// 上线
		public static final Byte ONLINE = 0;
		// 下线
		public static final Byte OFFLINE = 1;
	}
	
	// 服务状态
	public static final class SERVICE_TICKET_STATUS {
		// 绑定
		public static final Byte TICKET_BIND = 0;
		// 预约中
		public static final Byte TICKET_ORDERING = 1;
		// 预约成功
		public static final Byte TICKET_ORDER_SUCCESS = 2;
		// 预约失败
		public static final Byte TICKET_ORDER_FAIL = 3;
		// 服务完成
		public static final Byte TICKET_SERVICE_FINISH = 4;
	}
	
	// 服务单状态
	public static final class SERVICE_TICKET_NEW_STATUS {
		// 新建
		public static final Byte TICKET_new = 0;
		// 服务承接中
		public static final Byte TICKET_ORDERING = 1;
		// 承接成功
		public static final Byte TICKET_ORDER_SUCCESS = 2;
		// 承接失败
		public static final Byte TICKET_ORDER_FAIL = 3;
		// 生效
		public static final Byte TICKET_EFFECTIVE = 4;
		// 失效
		public static final Byte TICKET_FAILURE  = 5;
		// 结束
		public static final Byte TICKET_SERVICE_FINISH = 6;
	}
	
	// 服务任务单状态
	public static final class SERVICE_TASK_STATUS {
		// 预约中
		public static final Byte ORDERING = 0;
		// 预约成功
		public static final Byte ORDER_SUCCESS = 1;
		// 预约失败
		public static final Byte ORDER_FAIL = 2;
		// 服务完成
		public static final Byte TASK_FINAL = 3;
		//取消任务
		public static final Byte TASK_CONCEL = 4;
	}
	
	// 服务性产品
	public static final class SERVICEPRODUCT {
		//停用
		public static final byte STATUS_DISABLED = 0;
		//启用
		public static final byte STATUS_ENABLED = 1;
	}

	public static final class INTERFACE_MSG {
		// 接口校验成功
		public static final String SUCCESS = "SUCCESS";
		public static final String MSG_SUCCESS = "操作成功";
		// 接口验证失败
		public static final String ERROR = "ERROR";
		public static final String MSG_ERROR = "操作失败";
		// 接口校验业务数据失败
		public static final String ERROR_VALIDATE_BIZ_DATA = "校验业务数据失败";
		// 重复提交
		public static final String ERROR_REPEAT_SUBMIT = "重复提交";
		// 接口异常
		public static final String ERROR_SYSTEM = "接口异常";
		// 商户订单号或保单号存在重复
		public static final String INVALID_POLICYNO_REPEAT = "商户订单号或保单号重复";
		// 接口appkey失效
		public static final String INVALID_APPKEY = "无效appKey";
		// 接口保单编码
		public static final String INVALID_POLICYNO_ABSENCE = "保单不存在";
		// 接口调用服务错误
		public static final String INVALID_SERVICE_ERROR = "调用服务错误";
		// 接口无效头信息
		public static final String ISNOTNULL_BIZ_PARAM = "相应业务参数不能为空";
		// 接口无效头信息
		public static final String ISNOTNULL_HEAD_PARAM = "相应头文件信息不能为空";
		// 接口只接受POST请求
		public static final String INVALID_REQUEST_INFO = "只接受POST请求";
		// 接口签名失败
		public static final String INVALID_SIGN_FAILED = "签名失败";
		// 接口加密失败
		public static final String INVALID_ENCODE_FAILED = "加密失败";
		// 接口解密失败
		public static final String INVALID_DECODE_FAILED = "解密失败";
		// 接口日期验证失败
		public static final String INVALID_DATE_FORMAT = "日期验证失败";
		// 接口系统参数验证失败
		public static final String INVALID_SYSTEM_PARAM = "系统级参数验证失败";
		//核保中状态状态不允许撤单
		public static final String INVALID_HANDLING_CANNOT_BACK = "保单为核保状态不允许撤单";
		//核保中状态状态不允许撤单
		public static final String INVALID_HANDLING_CANNOT_CLAIM = "当前保单状态不允许理赔";
	}

	/**
	 * 系统初始化数据
	 */
	public static final class Initliaze {
		// 每页显示数
		public static final int PAGE_SHOWCOUNT = Integer
				.parseInt(SecurityProperties.getInstance().getProperty(
						"page.showCount"));
		//运行环境
		public static final String SYSTEM_ENVIRONMENT="system.environment";
	}

	// 消息提醒模式
	public static final class msgNotify {
		// 邮件提醒
		public static final Byte NOTIFY_MAIL = 0;
		// 短信提醒
		public static final Byte NOTIFY_SMS = 1;
	}

	// 消息提醒状态
	public static final class msgStatus {
		// 已发送
		public static final Byte SENT = 1;
		// 未发送
		public static final Byte UNSENT = 0;
	}

	// 交易资金状态
	public static final class TRADE_STATUS {
		// 交易成功
		public static final int SUCCESS = 0;
		// 交易失败
		public static final int FAIL = 1;
		// 交易账户问题
		public static final int ACCOUNT_ERRO = 2;
		// 交易必填项
		public static final int CHECK_FAILURE = 3;
		// 交易中
		public static final int TRADEING = 4;
	}

	// 交易单号来源
	public static final class TRADE_NO_ORIGIN {
		//订单
		public static final int ORDER_TYPE = 0;
		//支付单
		public static final int PAYMENT_TYPE = 1;
		//充值单号
		public static final int RECHARGE_TYPE = 2;
	}

	
	// 交易资金状态
	public static final class TRADE_TYPE {
		// 充值
		public static final int RECHARGE = 0;
		// 支付
		public static final int PAYMENT = 1;
		// 收入
		public static final int INCOME = 2;
	}

	// 撤单结果
	public static final class POLICY_BACK_RESULT {
		// 退单成功
		public static final String RESULT_SUC = "撤单成功";
		// 退单失败
		public static final String RESULT_ERROR = "撤单失败";
	}

	// 订单状态
	public static final class ORDER_STATUS {
		// 待支付
		public static final Byte UNPAID = 0;
		// 投保中(寿险中当作支付中处理)
		public static final Byte INSURING = 1;
		// 投保完成
		public static final Byte INSURE_COMPLETE = 2;
		// 支付完成
		public static final Byte PREPAID = 3;
		// 支付失败
		public static final Byte PAY_FAIL = 32;
		// 已过期
		public static final Byte EXPIRED  = 4;
		// 废弃-校验失败导致
		public static final Byte DISUSED_VALID_FAIL  = 51;
	}
	
	// 订单校验状态
	public static final class ORDER_VALID_FLAG {
		// 校验中
		public static final Byte VALIDING = 0;
		// 校验成功
		public static final Byte VALID_SUCCESS = 1;
		// 校验失败
		public static final Byte VALID_FAIL = 2;
	}
	
	//对账周期
	public static final class CHECK_CYCLE {
		//日
		public static final byte DAY = COMMON.DAY;
		//周
		public static final byte WEEK = COMMON.WEEK;
		//旬
		public static final byte TENDAY = COMMON.TENDAY;
		//月
		public static final byte MONTH = COMMON.MONTH;
	}
	
	// 订单用户类型,0：投保人；1：被保人；2本人投保
	public static final class ORDER_USER_TYPE {
		// 下单人
		public static final String ORDER_PAY = "0";
		// 被保人
		public static final String ORDER_SERVICED = "1";
		//本人投保
		public static final String ORDER_ONESELF = "2";
		//相关人
		public static final String ORDER_rel = "3";
	}
	
	//通用常量
	public static final class COMMON {
		//成功
		public static final String SUCCESS = "success";
		//失败
		public static final String ERROR = "error";
		//token验证表单重复提交,放入session中的名字
		public static final String FORM_TOKEN_NAME="form_token_uuid";
		//get请求对应的方法名字
		public static final String REQUEST_GET_NAME="GET";
		//使用母版页渲染
		public static final String USE_TEMPLATE_PARENT="use_template_parent";
		//母版页返回参数
		public static final String PARENT_TEMPLATE_OBJ="parent_template_obj";
		//数据来源自助平台
		public static final String DATA_CHANNEL_SELFPLATFORM = "selfPlat";//selfPlat:自助平台;baseManage:后台管理;interface:接口;wechat:微信;
		//数据来源后台管理
		public static final String DATA_CHANNEL_BASEMANAGE = "baseManage";//selfPlat:自助平台;baseManage:后台管理;interface:接口;wechat:微信;
		//数据来源接口
		public static final String DATA_CHANNEL_INTERFACE = "interface";//selfPlat:自助平台;baseManage:后台管理;interface:接口;wechat:微信;
		//数据来源微信平台
		public static final String DATA_CHANNEL_WECHAT = "wechat";//selfPlat:自助平台;baseManage:后台管理;interface:接口;wechat:微信;
		//数据来源APP
		public static final String DATA_CHANNEL_APP = "app";//selfPlat:自助平台;baseManage:后台管理;interface:接口;wechat:微信;
		//0：否
		public static final Byte NO = 0;
		//1：是
		public static final Byte YES = 1;
		//日
		public static final byte DAY = 1;
		//周
		public static final byte WEEK = 2;
		//旬
		public static final byte TENDAY = 3;
		//月
		public static final byte MONTH = 4;
		//年
		public static final byte YEAR = 5;
		//证件隐藏部分信息正则
		public static final String regexId = "(\\w{4})(\\w+)(\\w{4})";
		//姓名隐藏部分信息正则
		public static final String regexName = "([\u4E00-\u9FA5]{1})([\u4E00-\u9FA5]*\\w*)";
		//手机号
		public static final String regexTel = "(\\d{3})(\\d+)(\\d{4})";
		
		public static final String PERSONNAL_REG = "个人注册";
	}
	
	//保险起期、止期时间类型
	public static final class INSURANCE_TIMETYPE {
		//投保时间
		public static final int INSUR_TIME = 1;
		//预约服务时间
		public static final int SUBSCRIBE_SERVICE_TIME = 2;
		//出发时间
		public static final int DEPART_TIME = 3;
		//服务开始时间
		public static final int SERVICE_START_TIME = 4;
		//服务结束时间
		public static final int SERVICE_END_TIME = 5;
		//保险起期
		public static final int INSURANCE_START_TIME = 6;
	}
	
	//保险起期、止期计算类型
	public static final class INSURANCE_TERMINATION_TYPE {
		//小时
		public static final int HOUR = 1;
		//天
		public static final int DAY = 2;
		//次日生效
		public static final int MORROW_OPERATIVE = 3;
		//月
		public static final int MONTH = 4;
		//年
		public static final int YEAR = 5;
	}
	
	//电动车的类型
	public static final class ELECTRICCAR_TYPE {
			
		//电动车
		public static final String ELECTRIC_CAR = "1";
		//滑板车
		public static final String SCOOTER = "2";
		//助力车
		public static final String BICYCLE = "3";
		//电动摩托车
		public static final String ELECTRIC_MOTORCYCLE = "4";
		//电动轿车
		public static final String ELECTRIC_CARS = "5";
		//其他电动整车
		public static final String OTHERS_ELECTRIC_CAR = "6";
		
	}
	
	//短信服务 serviceName 常量
	public static final class SMS_SERVICE_NAME {
		//美分期投保
		public static final String MFQ_TB = "MFQ_TB";
	}
	
	//系统中缓存机制常用常量
	public static final class SYS_CACHE {
		//字典对象键值前缀
		public static final String DICT_OBJ_KEY_PREFIX="dict_cache_obj_";
		//json格式字典键值前缀
		public static final String DICT_JSON_KEY_PREFIX="dict_cache_json_";
		//活动对象键值前缀
		public static final String DICT_ACTIVITY_KEY_PREFIX="dict_activity_key_";
		//角色权限键值前缀
		public static final String ROLE_AUTHORITY_KEY_PREFIX="role_authority_cache_";
		//用户所拥有的角色编码
		public static final String USER_ROLE_KEY_PREFIX="user_role_cache_";
		//
		public static final String DICT_OBJ_ALL_ADMINUSER_INFO="dict_obj_all_adminuser_info";
		//线下投保批次
		public static final String OFFLINE_BATCHNO="OFFLINE_BATCHNO_";
		//映射表
		public static final String INFO_MAPPING_TABLE_KEY_PREFIX="info_mapping_table_";
		//判断是否提现过
		public static final String  THE_EXPLOSION_WITHDRAWALS = "the_explosion_ithdrawals_";
	}
	
	//redis中公用key
	public static final class RedisKey {
		//登陆用户信息
		public static final String PASSPORT_LOGIN_USER="platform_passport_login_user";
		//登陆用户客户端信息
		public static final String PASSPORT_LOGIN_CLIENTADDR="platform_passport_login_clientaddr";
		//平台全局配置
		public static final String PLATFORM_GLOBAL_CONFIG="platform_global_config";
		//enum配置
		public static final String REDIS_CACHE_FOR_ENUMS="redis_cache_for_enums";
	}
	
	public static final class BUS_EXCEPTION_TYPE{
		/*支付单类型*/
		public static final int PAYMENT_TRANSACTION_TYPE = 0;
		/*保单类型*/
		public static final int POLICY_TRANSACTION_TYPE = 1;
		/*错误异常*/
		public static final int ERROR_EXCEPTION_TYPE = 0;
		/*失败异常*/
		public static final int FAILD_EXCEPTION_TYPE = 1;
		/*http 调用异常*/
		public static final int HTTP_EXCEPTION_TYPE = 2;
	}
	
	//微信公众平台中的key
	public static final class WechatKey {
		//用户微信openid（session）
		public static final String SESSION_WECHAT_USER_OPENID="session_wechat_user_openid";
		//平台access_token（redis）
		public static final String REDIS_WECHAT_ACCESS_TOKEN="redis_wechat_access_token";
		//平台jsapi_ticket（redis）
		public static final String REDIS_WECHAT_JSAPI_TICKET="redis_wechat_jsapi_ticket";
		//申请微信授权state
		public static final String SESSION_WECHAT_AUTHORIZATION_STATE="session_wechat_authorization_state";
		//存取在redis包装的session中的短信随机码
		public static final String REDIS_SESSION_MESSAGE_CODE="redis_session_message_code";
		//用户微信信息
		public static final String SESSION_WECHAT_THIRDINFO="redis_session_wechat_thirdinfo";
		//用户网页授权access_token（redis）
		public static final String REDIS_WECHAT_WEB_ACCESS_TOKEN="redis_wechat_web_access_token";
		//用户网页授权refresh_token（redis）
		public static final String REDIS_WECHAT_WEB_REFRESH_TOKEN="redis_wechat_web_refresh_token";
		//车险accessToken
		public static final String CAR_ACCESSTOKEN = "wx_car_access_token";
		//车险carOpenId
		public static final String CAR_OPEN_ID = "wx_car_openid";
	}
	
	//车险中的key
	public static final class WkbCarKey {
   	    //acessToken
	    public static final String REDIS_CAR_ACCESSTOKEN="redis_car_accesstoken";
	    //acessToken生成时间
	    public static final String CAR_ACCESSTOKEN_GENERATION_TIME="generation_time";
	    //过期时间
	    public static final String CAR_ACCESSTOKEN_EXPIRE_TIME="expire_time";
	    //是否是最新
	    public static final String ISLATEST="isLatest";
		//merchantCode
		public static final String MERCHANT_CODE="merchantCode";
		//userId商户对应的code
		public static final String USERID="userId";
		//错误编码
		public static final String MERCHANTCODE_ERROR = "merchantcode_Error";
		//错误编码
		public static final String ACCESSTOKEN_ERROR = "accesstoken_Error";
		//accesstoken
		public static final String ACCESS_TOKEN="access_token";
		//refreshToken
		public static final String REFRESH_TOKEN="refresh_token";
		//accessTokenAll
		public static final String ACCESS_TOKEN_ALL="access_token_all";
		//openId
	    public static final String OPENID="openId";
	    //openId_error
	    public static final String OPENID_ERROR="openId_Error";
	    //是
	    public static final String YES="1";
        //否
	    public static final String NO="0";
	    //accessToken过期时间
	    public static final Long ACCESS_TOKEN_EXPIRE_TIME=10800L;//秒
	}
	/**
	 * 发送短信键值
	 */
	public static final class SendMessageKey {
		//短信随机验证码
		public static final String MESSAGE_CODE="message_code";
		//有效期时长
		public static final String EXPIRE_SECONDS="expire_seconds";
		//手机号码
		public static final String PHONE_NUM="phone_num";
		//过期时间
		public static final String EXPIRE_TIME="expire_time";
	}
	
	/**
	 * 第三方账号登陆绑定类型
	 */
	public static final class ThirdUserBindType {
		//手机号绑定
		public static final String USER_PHONE="user_phone";
		//邮箱绑定
		public static final String USER_EMAIL="user_email";
		//账号绑定
		public static final String USER_ACCOUNT="user_account";
	}
	
	/**
	 * 证件类型
	 */
	public static final class IDType {
		//身份证
		public static final String IDTYPE_SFZ="1";
		//护照
		public static final String IDTYPE_HZ="2";
		//军官证
		public static final String IDTYPE_JGZ="3";
		//港台通报
		public static final String IDTYPE_GTTB="4";
		//户口簿
		public static final String IDTYPE_HKB="5";
		//士兵证
		public static final String IDTYPE_SBZ="6";
		//驾驶执照
		public static final String IDTYPE_JSZ="7";
		//返乡证
		public static final String IDTYPE_FXZ="8";
		//组织机构代码
		public static final String IDTYPE_ZZJG="9";
		//港澳通行证
		public static final String IDTYPE_GOTXZ="10";
		//台湾通行证
		public static final String IDTYPE_TWTXZ="11";
		//其他
		public static final String IDTYPE_QT="12";
		//企业营业执照
		public static final String QY_IDTYPE_YYZZ="21";
	}
	
	/**
	 * 权限类型
	 */
	public static class AuthorityType {
		//模块
		public static final int MODULE=1;
		//功能
		public static final int FUNCTION=2;
		//操作
		public static final int OPERATE=3;
	}
	
	/**
	 * 后台管理用户类型
	 */
	public static class SysUserType {
		//超级管理员
		public static final String SUPER_ADMIN="superadmin";
		//普通管理员
		public static final String NORMAL_ADMIN="admin";
		//普通员工
		public static final String NORMAL_STAFF="staff";
	}
	
	/**
	 * 业务和用户关联关系表
	 */
	public static class RelationUser {
		
		public static final byte is_default_yes = 1; //默认联系人
		public static final byte is_default_no = 0;  //非默认联系人
	}
	
	public static final byte READ = 1;  //已读
	public static final byte UNREAD = 0; //未读
	
	/**
	 * 发票状态
	 * @author hujie
	 *
	 */
	public static class FinaceBillStatu{
		public static final Integer APPLICATION_STATU = 0;		//申请发票
		public static final Integer HANDLE_STATU = 1;			//处理发票
		public static final Integer SEND_BILL_STATU=2;			//邮寄发票
		public static final Integer FINISH_STATU = 3;			//完成收到
	}
	
	/**
	 * 邮件发送状态
	 * @author zhangjm
	 *
	 */
	public static class EmailStatus{
		/** 正常 **/
		public static final byte normal = 1;
		/** 异常 **/
		public static final byte abnormal = 0; 
	}
	
	/**
	 * 系统级参数
	 *
	 */
	public static final class System{
		//servlet容器
		public static ServletContext SERVLET_CONTEXT;
		
		//系统环境
		public static String ENVIRONMENT = "debug";
	}
	
	/**
	 * CRM 用户类型
	 */
	public static class CrmCbType{
		public static final Integer POLICY = 1;//保单用户
		public static final Integer WE_CHAT = 2;//微信绑定用户
	}
	/** 
	 * 车险保险公司费率
	 */
	public static class CarInsurerRate{
	        //失效
	        public static final byte STATUS_DISABLED = 0;
	        //有效
	        public static final byte STATUS_ENABLED = 1;
	}
	/**
	 * 车险保险公司费率详情
	 */
	public static class CarInsurerRateDetail{
	    //失效
	    public static final byte STATUS_DISABLED = 0;
	    //有效
	    public static final byte STATUS_ENABLED = 1;
	}
	public static class CarRate{
	    //策略类型
	    public static final byte POLICY_TYPE_QUOTA=0;//定额
	    public static final byte POLICY_TYPE_REGULAR=1;//定期
	    //结算周期
            public static final byte DAY =0; //日
           
            public static final byte WEEK =1; //周 
            public static final byte MONTH =2;//月
            public static final byte QUARTER=3;//季
            //定额类型
            public static final byte QUOTA_TYPE_MONTH=1;//每月定额
            public static final byte QUOTA_TYPE_ORDER=0;//每单定额
	}
	
	public static class CarRegularRate{
	    //未生效
            public static final byte STATUS_WAIT_ENABLED = 0;
            //有效
            public static final byte STATUS_ENABLED = 1;
            //失效
            public static final byte STATUS_DISABLED = 2;
	}
	
	/**
	 * ActiveMq 队列
	 * @author zhangjm
	 *
	 */
	public static class ActiveMqQueue{
		public static final String OFFLINEINSURANCE = "offlineInsurance.queue";
		public static final String POLICY_EXPORT = "policyExport.queue";
	}
	
	/**
	 * 核保数据信息
	 */
	public static class BusinessUnderwritingInfo {
		/* 核保状态--核保中 */
		public static final int STATUS_UNDERWRITING = 0;
		/* 核保状态--核保成功 */
		public static final int STATUS_SUCCEED = 1;
		/* 核保状态--核保失败 */
		public static final int STATUS_FAILED = 2;
		/* 核保状态--关闭 */
		public static final int STATUS_CLOSED = 3;
	}
	/**
	 *异常保单状态
	 */
	public static class BusinessInsurancePolicyException{
	    public static final int STATUS_FAILED = 0;//投保失败
	    public static final int STATUS_AGAIN = 1;//再次投保
	    public static final int STATUS_REFUSE = 2;//拒绝承保
	    public static final int STATUS_OFFLINE = 3;//线下投保
	    public static final int STATUS_SUCCEED = 4;//投保成功
	}
	/**
	 * 部门状态
	 */
	public static  class SysDepartment{
		public static final byte STATUS_ENABLED = 1;//启用
		public static final byte STATUS_DISABLED = 0;//删除
		
	}
	
	/**
	 *投保字段-0:投保人,1:被保人,2:其他
	 */
	public static  class ProductsFieldType{
		public static final Integer  TOUBAOREN= 0;//投保人
		public static final Integer  BEIBAOREN = 1;//被保人
		public static final Integer  QITA = 2;//被保人
	}
	
	/**
	 *投保失败后，拒绝承保，给客户发送的错误码
	 */
	public static  class RefuseToInsureError{
		public static final Integer  REPEAT_CODE= 300;//重复投保
		public static final Integer  INSURED_REPEAT_CODE= 301;//被保人重复重复投保
	}
}
