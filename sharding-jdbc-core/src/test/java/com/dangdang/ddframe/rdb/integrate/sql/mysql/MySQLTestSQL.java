/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License";
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.integrate.sql.mysql;

import com.dangdang.ddframe.rdb.integrate.sql.DatabaseTestSQL;

public final class MySQLTestSQL implements DatabaseTestSQL {
    
    private static final String SELECT_COUNT_ALIAS_SQL = "SELECT COUNT(*) AS `orders_count` FROM `t_order`";
    
    private static final String SELECT_COUNT_SQL = "SELECT COUNT(*) FROM `t_order`";
    
    private static final String SELECT_SUM_ALIAS_SQL = "SELECT SUM(`user_id`) AS `user_id_sum` FROM `t_order`";
    
    private static final String SELECT_SUM_SQL =  "SELECT SUM(`user_id`) FROM `t_order`";
    
    private static final String SELECT_MAX_ALIAS_SQL = "SELECT MAX(`user_id`) AS `max_user_id` FROM `t_order`";
    
    private static final String SELECT_MAX_SQL = "SELECT MAX(`user_id`) FROM `t_order`";
    
    private static final String SELECT_MIN_ALIAS_SQL = "SELECT MIN(`user_id`) AS `min_user_id` FROM `t_order`";
    
    private static final String SELECT_MIN_SQL = "SELECT MIN(`user_id`) FROM `t_order`";
    
    private static final String SELECT_AVG_ALIAS_SQL = "SELECT AVG(`user_id`) AS `user_id_avg` FROM `t_order`";
    
    private static final String SELECT_AVG_SQL = "SELECT AVG(`user_id`) FROM `t_order`";
    
    private static final String SELECT_COUNT_WITH_BINDING_TABLE_SQL = "SELECT COUNT(*) AS `items_count` FROM `t_order` o JOIN `t_order_item` i "
            + "ON o.user_id = i.user_id AND o.order_id = i.order_id WHERE o.`user_id` IN (%s, %s) AND o.`order_id` BETWEEN %s AND %s";
    
    private static final String INSERT_WITH_ALL_PLACEHOLDERS_SQL = "INSERT INTO `t_order` (`order_id`, `user_id`, `status`) VALUES (?, ?, ?)";
    
    private static final String INSERT_WITH_PARTIAL_PLACEHOLDERS_SQL = "INSERT INTO `t_order` (`order_id`, `user_id`, `status`) VALUES (%s, %s, ?)";
    
    private static final String INSERT_WITHOUT_PLACEHOLDER_SQL = "INSERT INTO `t_order` (`order_id`, `user_id`, `status`) VALUES (%s, %s, 'insert')";
    
    private static final String INSERT_WITH_AUTO_INCREMENT_COLUMN_SQL = "INSERT INTO `t_order` (`user_id`, `status`) VALUES (%s, %s)";
    
    private static final String UPDATE_WITHOUT_ALIAS_SQL = "UPDATE `t_order` SET `status` = %s WHERE `order_id` = %s AND `user_id` = %s";
    
    private static final String UPDATE_WITH_ALIAS_SQL = "UPDATE `t_order` AS o SET o.`status` = ? WHERE o.`order_id` = ? AND o.`user_id` = ?";
    
    private static final String UPDATE_WITHOUT_SHARDING_VALUE_SQL = "UPDATE `t_order` SET `status` = %s WHERE `status` = %s";
    
    private static final String DELETE_WITHOUT_ALIAS_SQL = "DELETE FROM `t_order` WHERE `order_id` = %s AND `user_id` = %s AND `status` = %s";
    
    private static final String DELETE_WITHOUT_SHARDING_VALUE_SQL = "DELETE FROM `t_order` WHERE `status` = %s";
    
    private static final String ASSERT_SELECT_WITH_STATUS_SQL = "SELECT * FROM `t_order` WHERE `status`=?";
    
    private static final String ASSERT_SELECT_SHARDING_TABLES_WITH_STATUS_SQL = "SELECT * FROM `t_order_%s` WHERE `status` = ?";
    
    private static final String SELECT_SUM_WITH_GROUP_BY_SQL = "SELECT SUM(order_id) AS `orders_sum`, `user_id` FROM `t_order` GROUP BY `user_id`";
    
    private static final String SELECT_SUM_WITH_ORDER_BY_AND_GROUP_BY_SQL = "SELECT SUM(order_id) AS `orders_sum`, `user_id` FROM `t_order` GROUP BY `user_id` ORDER BY `user_id`";
    
    private static final String SELECT_COUNT_WITH_GROUP_BY_SQL = "SELECT COUNT(order_id) AS `orders_count`, `user_id` FROM `t_order` GROUP BY `user_id`";
    
    private static final String SELECT_MAX_WITH_GROUP_BY_SQL = "SELECT MAX(order_id) AS `max_order_id`, `user_id` FROM `t_order` GROUP BY `user_id`";
    
    private static final String SELECT_MIN_WITH_GROUP_BY_SQL = "SELECT MIN(order_id) AS `min_order_id`, `user_id` FROM `t_order` GROUP BY `user_id`";
    
    private static final String SELECT_AVG_WITH_GROUP_BY_SQL = "SELECT AVG(order_id) AS `orders_avg`, `user_id` FROM `t_order` GROUP BY `user_id`";
    
    private static final String SELECT_SUM_WITH_ORDER_BY_DESC_AND_GROUP_BY_SQL = "SELECT SUM(order_id) AS `orders_sum`, `user_id` FROM `t_order` GROUP BY `user_id` ORDER BY orders_sum DESC";
    
    private static final String SELECT_EQUALS_WITH_SINGLE_TABLE_SQL = "SELECT * FROM `t_order` WHERE `user_id` = %s AND `order_id` = %s";
    
    private static final String SELECT_BETWEEN_WITH_SINGLE_TABLE_SQL = "SELECT * FROM `t_order` WHERE `user_id` BETWEEN %s AND %s AND `order_id` BETWEEN %s AND %s ORDER BY user_id, order_id";
    
    private static final String SELECT_IN_WITH_SINGLE_TABLE_SQL = "SELECT * FROM `t_order` WHERE `user_id` IN (%s, %s, %s) AND `order_id` IN (%s, %s) ORDER BY user_id, order_id";
    
    private static final String SELECT_LIMIT_WITH_BINDING_TABLE_SQL = "SELECT i.* FROM `t_order` o JOIN `t_order_item` i ON o.user_id = i.user_id AND o.order_id = i.order_id"
            + " WHERE o.`user_id` IN (%s, %s) AND o.`order_id` BETWEEN %s AND %s ORDER BY i.item_id DESC LIMIT %s, %s";
    
    private static final String SELECT_ORDER_BY_WITH_ALIAS_SQL = "SELECT order_id as `order_id_alias`,user_id,status FROM `t_order` " 
            + "WHERE `user_id` BETWEEN %s AND %s AND `order_id` BETWEEN %s AND %s ORDER BY user_id, order_id";
    
    private static final String SELECT_LIMIT_WITH_BINDING_TABLE_WITHOUT_OFFSET_SQL = "SELECT i.* FROM `t_order` o JOIN `t_order_item` i ON o.user_id = i.user_id AND o.order_id = i.order_id"
            + " WHERE o.`user_id` IN (%s, %s) AND o.`order_id` BETWEEN %s AND %s ORDER BY i.item_id DESC LIMIT %s";
    
    private static final String SELECT_GROUP_WITH_BINDING_TABLE_SQL = "SELECT count(*) as items_count, o.`user_id` FROM `t_order` o JOIN `t_order_item` i " 
            + "ON o.user_id = i.user_id AND o.order_id = i.order_id WHERE o.`user_id` IN (%s, %s) AND o.`order_id` BETWEEN %s AND %s GROUP BY o.`user_id`";
    
    private static final String SELECT_GROUP_WITH_BINDING_TABLE_AND_CONFIG_SQL = "SELECT i.* FROM `t_order` o JOIN `t_order_item` i ON o.user_id = i.user_id AND o.order_id = i.order_id "
            + "JOIN `t_config` c ON o.status = c.status WHERE o.`user_id` IN (%s, %s) AND o.`order_id` BETWEEN %s AND %s AND c.status = %s ORDER BY i.item_id";
    
    private static final String SELECT_GROUP_WITHOUT_GROUPED_COLUMN_SQL = "SELECT count(*) as items_count FROM `t_order` o JOIN `t_order_item` i ON o.user_id = i.user_id AND o.order_id = i.order_id"
            + " WHERE o.`user_id` IN (%s, %s) AND o.`order_id` BETWEEN %s AND %s GROUP BY o.`user_id`";
    
    private static final String SELECT_WITH_NO_SHARDING_TABLE_SQL = "SELECT i.* FROM `t_order` o JOIN `t_order_item` i ON o.user_id = i.user_id AND o.order_id = i.order_id ORDER BY i.item_id";
    
    @Override
    public String getSelectCountSql() {
        return SELECT_COUNT_SQL;
    }
    
    @Override
    public String getSelectCountAliasSql() {
        return SELECT_COUNT_ALIAS_SQL;
    }
    
    @Override
    public String getSelectSumSql() {
        return SELECT_SUM_SQL;
    }
    
    @Override
    public String getSelectSumAliasSql() {
        return SELECT_SUM_ALIAS_SQL;
    }
    
    @Override
    public String getSelectMaxSql() {
        return SELECT_MAX_SQL;
    }
    
    @Override
    public String getSelectMaxAliasSql() {
        return SELECT_MAX_ALIAS_SQL;
    }
    
    @Override
    public String getSelectMinSql() {
        return SELECT_MIN_SQL;
    }
    
    @Override
    public String getSelectMinAliasSql() {
        return SELECT_MIN_ALIAS_SQL;
    }
    
    @Override
    public String getSelectAvgSql() {
        return SELECT_AVG_SQL;
    }
    
    @Override
    public String getSelectAvgAliasSql() {
        return SELECT_AVG_ALIAS_SQL;
    }
    
    @Override
    public String getSelectCountWithBindingTableSql() {
        return SELECT_COUNT_WITH_BINDING_TABLE_SQL;
    }
    
    @Override
    public String getInsertWithAutoIncrementColumnSql() {
        return INSERT_WITH_AUTO_INCREMENT_COLUMN_SQL;
    }
    
    @Override
    public String getInsertWithAllPlaceholdersSql() {
        return INSERT_WITH_ALL_PLACEHOLDERS_SQL;
    }
    
    @Override
    public String getInsertWithPartialPlaceholdersSql() {
        return INSERT_WITH_PARTIAL_PLACEHOLDERS_SQL;
    }
    
    @Override
    public String getInsertWithoutPlaceholderSql() {
        return INSERT_WITHOUT_PLACEHOLDER_SQL;
    }
    
    @Override
    public String getUpdateWithoutAliasSql() {
        return UPDATE_WITHOUT_ALIAS_SQL;
    }
    
    @Override
    public String getUpdateWithAliasSql() {
        return UPDATE_WITH_ALIAS_SQL;
    }
    
    @Override
    public String getUpdateWithoutShardingValueSql() {
        return UPDATE_WITHOUT_SHARDING_VALUE_SQL;
    }
    
    @Override
    public String getDeleteWithoutAliasSql() {
        return DELETE_WITHOUT_ALIAS_SQL;
    }
    
    @Override
    public String getDeleteWithoutShardingValueSql() {
        return DELETE_WITHOUT_SHARDING_VALUE_SQL;
    }
    
    @Override
    public String getAssertSelectWithStatusSql() {
        return ASSERT_SELECT_WITH_STATUS_SQL;
    }
    
    @Override
    public String getAssertSelectShardingTablesWithStatusSql() {
        return ASSERT_SELECT_SHARDING_TABLES_WITH_STATUS_SQL;
    }
    
    @Override
    public String getSelectSumWithGroupBySql() {
        return SELECT_SUM_WITH_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectSumWithOrderByAndGroupBySql() {
        return SELECT_SUM_WITH_ORDER_BY_AND_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectSumWithOrderByDescAndGroupBySql() {
        return SELECT_SUM_WITH_ORDER_BY_DESC_AND_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectCountWithGroupBySql() {
        return SELECT_COUNT_WITH_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectMaxWithGroupBySql() {
        return SELECT_MAX_WITH_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectMinWithGroupBySql() {
        return SELECT_MIN_WITH_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectAvgWithGroupBySql() {
        return SELECT_AVG_WITH_GROUP_BY_SQL;
    }
    
    @Override
    public String getSelectEqualsWithSingleTableSql() {
        return SELECT_EQUALS_WITH_SINGLE_TABLE_SQL;
    }
    
    @Override
    public String getSelectBetweenWithSingleTableSql() {
        return SELECT_BETWEEN_WITH_SINGLE_TABLE_SQL;
    }
    
    @Override
    public String getSelectInWithSingleTableSql() {
        return SELECT_IN_WITH_SINGLE_TABLE_SQL;
    }
    
    @Override
    public String getSelectLimitWithBindingTableSql() {
        return SELECT_LIMIT_WITH_BINDING_TABLE_SQL;
    }
    
    @Override
    public String getSelectOrderByWithAliasSql() {
        return SELECT_ORDER_BY_WITH_ALIAS_SQL;
    }
    
    @Override
    public String getSelectLimitWithBindingTableWithoutOffsetSql() {
        return SELECT_LIMIT_WITH_BINDING_TABLE_WITHOUT_OFFSET_SQL;
    }
    
    @Override
    public String getSelectLimitWithBindingTableWithOffsetSql() {
        return SELECT_LIMIT_WITH_BINDING_TABLE_WITHOUT_OFFSET_SQL;
    }
    
    @Override
    public String getSelectGroupWithBindingTableSql() {
        return SELECT_GROUP_WITH_BINDING_TABLE_SQL;
    }
    
    @Override
    public String getSelectGroupWithBindingTableAndConfigSql() {
        return SELECT_GROUP_WITH_BINDING_TABLE_AND_CONFIG_SQL;
    }
    
    @Override
    public String getSelectGroupWithoutGroupedColumnSql() {
        return SELECT_GROUP_WITHOUT_GROUPED_COLUMN_SQL;
    }
    
    @Override
    public String getSelectWithNoShardingTableSql() {
        return SELECT_WITH_NO_SHARDING_TABLE_SQL;
    }
}
