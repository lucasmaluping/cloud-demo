//package com.lucas.consumer.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @Author Lucas
// * @Date 2019/12/19 22:15
// * @Version 1.0
// */
//
//@Service
//@Transactional
//public class OrderServiceImpl {
//
//    @Autowired
//    private TbOrderMapper orderMapper;
//
//    @Autowired
//    private TbOrderItemMapper orderItemMapper;
//
//    @Override
//    public Map<String, Double> findSaleData(String start, String end, String sellerId) {
//        Map<String, Double> map = new HashMap();
//        try {
//            //根据用户名，开始时间，结束时间查询订单
//            TbOrderExample example = new TbOrderExample();
//            Criteria criteria = example.createCriteria();
//            //将String 转换成Date
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateStart = dateFormat.parse(start);
//            Date dateEnd = dateFormat.parse(end);
//            //添加日期查询条件
//            criteria.andPaymentTimeBetween(dateStart, dateEnd);
//            //添加商家id查询条件
//            criteria.andSellerIdEqualTo(sellerId);
//            List<TbOrder> orderList = orderMapper.selectByExample(example);
//            //确保有数据再去订单明细表里查询数量
//            if (orderList != null && orderList.size() > 0) {
//                //遍历订单集合，查询每个订单的销售数量
//                for (TbOrder order : orderList) {
//                    Date paymentTime = order.getPaymentTime();
//                    //Date换成String
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    String dateStr = sdf.format(paymentTime);
//                    //获取支付金额
//                    BigDecimal payment = order.getPayment();
//                    if(map.containsKey(dateStr)){
//                        //累加销售额
//                        map.put(dateStr,payment.doubleValue()+map.get(dateStr));
//                    }else {
//                        map.put(dateStr,payment.doubleValue());
//                    }
//                }
//            } else {
//                return new HashMap();
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return new HashMap();
//        }
//        System.out.println(map);
//        return map;
//    }
//}
