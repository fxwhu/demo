local function limit_ip_per_min(ip)
    local result = {};
    local nums = redis.call("GET", ip);
    if nums >= 10 then
        result["code"] = "001";
        result["nums"] = "0";
        return result;
    end
    result["code"] = "000";
    result["nums"] = redis.call("INCR", ip);
    redis.call("EXPIRE", ip, 10);
    return result;
end

local ip = KEYS[1];
return cjson.encode(limit_ip_per_min("ip:"..ip));

