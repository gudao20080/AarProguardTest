package com.example.aarproguardtest.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 *
 *<p>
 *    <a href="http://wiki.8win.com/pages/viewpage.action?pageId=14287805">101064 订单转让项</a>
 *</p>
 * @author WangKai
 */
public class TransferInfo implements Parcelable {

    private String id;                //string	是	订单id
    private String amount;            // 	long	是	投注金额	单位：分
    private String multiple;            // 	long	是	倍数
    private String lotteryType;        // 	 	int	是	彩种编码	见101060-新投注 说明
    private String lotteryTypeName;    // 	 	 	string	是	彩种名称
    private String playType;            // 	int	是	玩法编码	见 101060-新投注 说明
    private String playTypeName;        // 	 	string	是	玩法名称
    private String phase;            // 	string	是	彩期
    private String orderType;        // 	 	int	是	订单类型	见 101060-新投注 说明
    private String orderTypeName;    // 	 	 	string	是	订单类型名称
    private String orderCreateType;    // 	 	 	int	是	订单创建类型	见 101060-新投注 说明
    private String orderCreateTypeName;             // 	 	 	string	是	订单创建类型名称
    private String orderWinningStatus;          // 	 	int	是	中奖状态编码	见 OrderWinningStatus说明
    private String orderWinningStatusName;          // 	 	 	string	是	中奖状态名称
    private String orderTicketStatus;           // 	int	是	出票状态编码	见 OrderTicketStatus说明
    private String orderTicketStatusName;           // 	 	string	是	出票状态名称
    private String orderPrizeStatus;            // 	int	是	派奖状态编码
    private String orderPrizeStatusName;            // 	 	string	是	派奖状态名称
    private String pretaxPrizeAmount;           // 	long	是	税前奖金	单位：分
    private String posttaxPrizeAmount;          // 	 	long	是	税后奖金	单位：分
    private String theoreticalMaxPrize;         // 	 	long	是	理论最高奖金	单位：分
    private String orderAddPrizeType;           // 	int	是	加奖类型编码
    private String orderAddPrizeTypeName;           // 	 	string	是	加奖类型名称
    private String addPrizeAmount;          // 	long	是	加奖金额	单位：分
    private String prizeTime;           //	string	是	派奖时间
    private String expectedPrizeTime;           //	 	 	string	是	预计开奖时间
    private String matchNums;           //	string	是	订单涉及的场次编号	多个编号以英文逗号分隔
    private String createdTime;         //	 	string	是	投注时间	格式如：2016-09-22 15:25:00
    private String transStatus;         //	 	int	是	转让状态	见 transStatus说明
    private String transAmount;         //	 	long	是	转让金额	单位：分

    /**
     * 子列表是否展开
     */
    private boolean isExpand = false; //

    private ArrayList<TransferMatch> matchList;//	list	是	比赛列表

    public static class TransferMatch implements Parcelable {

        private String matchId;         //	 	string	是	比赛id	如：201710301001
        private String matchNo;         //	 	string	是	比赛编码	如：周三 001
        private String league;          //	 	string	是	联赛名
        private String home;            //	string	是	主队名
        private String away;            //	string	是	客队名
        private String matchStatus;         //	 	 	int	是	比赛状态
        private ArrayList<TransferSp> spList;           // 是	sp列表

        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
            this.matchId = matchId;
        }

        public String getMatchNo() {
            return matchNo;
        }

        public void setMatchNo(String matchNo) {
            this.matchNo = matchNo;
        }

        public String getLeague() {
            return league;
        }

        public void setLeague(String league) {
            this.league = league;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getAway() {
            return away;
        }

        public void setAway(String away) {
            this.away = away;
        }

        public String getMatchStatus() {
            return matchStatus;
        }

        public void setMatchStatus(String matchStatus) {
            this.matchStatus = matchStatus;
        }

        public ArrayList<TransferSp> getSpList() {
            return spList;
        }

        public void setSpList(ArrayList<TransferSp> spList) {
            this.spList = spList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.matchId);
            dest.writeString(this.matchNo);
            dest.writeString(this.league);
            dest.writeString(this.home);
            dest.writeString(this.away);
            dest.writeString(this.matchStatus);
            dest.writeTypedList(this.spList);
        }

        public TransferMatch() {
        }

        protected TransferMatch(Parcel in) {
            this.matchId = in.readString();
            this.matchNo = in.readString();
            this.league = in.readString();
            this.home = in.readString();
            this.away = in.readString();
            this.matchStatus = in.readString();
            this.spList = in.createTypedArrayList(TransferSp.CREATOR);
        }

        public static final Creator<TransferMatch> CREATOR = new Creator<TransferMatch>() {
            @Override
            public TransferMatch createFromParcel(Parcel source) {
                return new TransferMatch(source);
            }

            @Override
            public TransferMatch[] newArray(int size) {
                return new TransferMatch[size];
            }
        };
    }

    public static class TransferSp implements Parcelable {

        private String playName;            //	string	是	玩法名称
        private String matchRet;            //	string	是	彩果	如：胜
        private String selects;         //	list	是	投注选项列表
        private String name;            //string	是	选项名称	如：胜
        private String jcSp;            //string	是	竞彩赔率	如：2.05
        private String addPercent;          //	string	是	加奖比例	如：0.039
        private String win;         //int	是	是否命中	0 否 1 是

        public String getPlayName() {
            return playName;
        }

        public void setPlayName(String playName) {
            this.playName = playName;
        }

        public String getMatchRet() {
            return matchRet;
        }

        public void setMatchRet(String matchRet) {
            this.matchRet = matchRet;
        }

        public String getSelects() {
            return selects;
        }

        public void setSelects(String selects) {
            this.selects = selects;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJcSp() {
            return jcSp;
        }

        public void setJcSp(String jcSp) {
            this.jcSp = jcSp;
        }

        public String getAddPercent() {
            return addPercent;
        }

        public void setAddPercent(String addPercent) {
            this.addPercent = addPercent;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.playName);
            dest.writeString(this.matchRet);
            dest.writeString(this.selects);
            dest.writeString(this.name);
            dest.writeString(this.jcSp);
            dest.writeString(this.addPercent);
            dest.writeString(this.win);
        }

        public TransferSp() {
        }

        protected TransferSp(Parcel in) {
            this.playName = in.readString();
            this.matchRet = in.readString();
            this.selects = in.readString();
            this.name = in.readString();
            this.jcSp = in.readString();
            this.addPercent = in.readString();
            this.win = in.readString();
        }

        public static final Creator<TransferSp> CREATOR = new Creator<TransferSp>() {
            @Override
            public TransferSp createFromParcel(Parcel source) {
                return new TransferSp(source);
            }

            @Override
            public TransferSp[] newArray(int size) {
                return new TransferSp[size];
            }
        };
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getLotteryTypeName() {
        return lotteryTypeName;
    }

    public void setLotteryTypeName(String lotteryTypeName) {
        this.lotteryTypeName = lotteryTypeName;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public String getPlayTypeName() {
        return playTypeName;
    }

    public void setPlayTypeName(String playTypeName) {
        this.playTypeName = playTypeName;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getOrderCreateType() {
        return orderCreateType;
    }

    public void setOrderCreateType(String orderCreateType) {
        this.orderCreateType = orderCreateType;
    }

    public String getOrderCreateTypeName() {
        return orderCreateTypeName;
    }

    public void setOrderCreateTypeName(String orderCreateTypeName) {
        this.orderCreateTypeName = orderCreateTypeName;
    }

    public String getOrderWinningStatus() {
        return orderWinningStatus;
    }

    public void setOrderWinningStatus(String orderWinningStatus) {
        this.orderWinningStatus = orderWinningStatus;
    }

    public String getOrderWinningStatusName() {
        return orderWinningStatusName;
    }

    public void setOrderWinningStatusName(String orderWinningStatusName) {
        this.orderWinningStatusName = orderWinningStatusName;
    }

    public String getOrderTicketStatus() {
        return orderTicketStatus;
    }

    public void setOrderTicketStatus(String orderTicketStatus) {
        this.orderTicketStatus = orderTicketStatus;
    }

    public String getOrderTicketStatusName() {
        return orderTicketStatusName;
    }

    public void setOrderTicketStatusName(String orderTicketStatusName) {
        this.orderTicketStatusName = orderTicketStatusName;
    }

    public String getOrderPrizeStatus() {
        return orderPrizeStatus;
    }

    public void setOrderPrizeStatus(String orderPrizeStatus) {
        this.orderPrizeStatus = orderPrizeStatus;
    }

    public String getOrderPrizeStatusName() {
        return orderPrizeStatusName;
    }

    public void setOrderPrizeStatusName(String orderPrizeStatusName) {
        this.orderPrizeStatusName = orderPrizeStatusName;
    }

    public String getPretaxPrizeAmount() {
        return pretaxPrizeAmount;
    }

    public void setPretaxPrizeAmount(String pretaxPrizeAmount) {
        this.pretaxPrizeAmount = pretaxPrizeAmount;
    }

    public String getPosttaxPrizeAmount() {
        return posttaxPrizeAmount;
    }

    public void setPosttaxPrizeAmount(String posttaxPrizeAmount) {
        this.posttaxPrizeAmount = posttaxPrizeAmount;
    }

    public String getTheoreticalMaxPrize() {
        return theoreticalMaxPrize;
    }

    public void setTheoreticalMaxPrize(String theoreticalMaxPrize) {
        this.theoreticalMaxPrize = theoreticalMaxPrize;
    }

    public String getOrderAddPrizeType() {
        return orderAddPrizeType;
    }

    public void setOrderAddPrizeType(String orderAddPrizeType) {
        this.orderAddPrizeType = orderAddPrizeType;
    }

    public String getOrderAddPrizeTypeName() {
        return orderAddPrizeTypeName;
    }

    public void setOrderAddPrizeTypeName(String orderAddPrizeTypeName) {
        this.orderAddPrizeTypeName = orderAddPrizeTypeName;
    }

    public String getAddPrizeAmount() {
        return addPrizeAmount;
    }

    public void setAddPrizeAmount(String addPrizeAmount) {
        this.addPrizeAmount = addPrizeAmount;
    }

    public String getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(String prizeTime) {
        this.prizeTime = prizeTime;
    }

    public String getExpectedPrizeTime() {
        return expectedPrizeTime;
    }

    public void setExpectedPrizeTime(String expectedPrizeTime) {
        this.expectedPrizeTime = expectedPrizeTime;
    }

    public String getMatchNums() {
        return matchNums;
    }

    public void setMatchNums(String matchNums) {
        this.matchNums = matchNums;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public ArrayList<TransferMatch> getMatchList() {
        return matchList;
    }

    public void setMatchList(ArrayList<TransferMatch> matchList) {
        this.matchList = matchList;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.amount);
        dest.writeString(this.multiple);
        dest.writeString(this.lotteryType);
        dest.writeString(this.lotteryTypeName);
        dest.writeString(this.playType);
        dest.writeString(this.playTypeName);
        dest.writeString(this.phase);
        dest.writeString(this.orderType);
        dest.writeString(this.orderTypeName);
        dest.writeString(this.orderCreateType);
        dest.writeString(this.orderCreateTypeName);
        dest.writeString(this.orderWinningStatus);
        dest.writeString(this.orderWinningStatusName);
        dest.writeString(this.orderTicketStatus);
        dest.writeString(this.orderTicketStatusName);
        dest.writeString(this.orderPrizeStatus);
        dest.writeString(this.orderPrizeStatusName);
        dest.writeString(this.pretaxPrizeAmount);
        dest.writeString(this.posttaxPrizeAmount);
        dest.writeString(this.theoreticalMaxPrize);
        dest.writeString(this.orderAddPrizeType);
        dest.writeString(this.orderAddPrizeTypeName);
        dest.writeString(this.addPrizeAmount);
        dest.writeString(this.prizeTime);
        dest.writeString(this.expectedPrizeTime);
        dest.writeString(this.matchNums);
        dest.writeString(this.createdTime);
        dest.writeString(this.transStatus);
        dest.writeString(this.transAmount);
        dest.writeByte(this.isExpand ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.matchList);
    }

    public TransferInfo() {
    }

    protected TransferInfo(Parcel in) {
        this.id = in.readString();
        this.amount = in.readString();
        this.multiple = in.readString();
        this.lotteryType = in.readString();
        this.lotteryTypeName = in.readString();
        this.playType = in.readString();
        this.playTypeName = in.readString();
        this.phase = in.readString();
        this.orderType = in.readString();
        this.orderTypeName = in.readString();
        this.orderCreateType = in.readString();
        this.orderCreateTypeName = in.readString();
        this.orderWinningStatus = in.readString();
        this.orderWinningStatusName = in.readString();
        this.orderTicketStatus = in.readString();
        this.orderTicketStatusName = in.readString();
        this.orderPrizeStatus = in.readString();
        this.orderPrizeStatusName = in.readString();
        this.pretaxPrizeAmount = in.readString();
        this.posttaxPrizeAmount = in.readString();
        this.theoreticalMaxPrize = in.readString();
        this.orderAddPrizeType = in.readString();
        this.orderAddPrizeTypeName = in.readString();
        this.addPrizeAmount = in.readString();
        this.prizeTime = in.readString();
        this.expectedPrizeTime = in.readString();
        this.matchNums = in.readString();
        this.createdTime = in.readString();
        this.transStatus = in.readString();
        this.transAmount = in.readString();
        this.isExpand = in.readByte() != 0;
        this.matchList = in.createTypedArrayList(TransferMatch.CREATOR);
    }

    public static final Creator<TransferInfo> CREATOR = new Creator<TransferInfo>() {
        @Override
        public TransferInfo createFromParcel(Parcel source) {
            return new TransferInfo(source);
        }

        @Override
        public TransferInfo[] newArray(int size) {
            return new TransferInfo[size];
        }
    };
}
