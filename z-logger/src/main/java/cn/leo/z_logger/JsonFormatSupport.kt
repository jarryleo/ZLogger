package cn.leo.z_logger

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.serializer.SerializerFeature

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

/**
 * 判断字符串是否是json
 */
fun String.isJson(): Boolean {
    return JSONObject.isValid(this)
}

/**
 * 格式化json字符串
 */
fun String.toJsonFormat(): String {
    return JSON.toJSONString(
        JSONObject.parseObject(this),
        SerializerFeature.PrettyFormat,
        SerializerFeature.WriteMapNullValue,
        SerializerFeature.WriteDateUseDateFormat
    )
}