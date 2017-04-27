local function sleep(n)
  os.execute("sleep " .. tonumber(n))
end

local function limit_ip_per_min(ip)
    local result = {};
    if redis.call("EXISTS", ip) == 1 then
        local nums = redis.call("GET", ip);
        if nums >= 10 then
            result["code"] = "001";
            result["nums"] = "0";
            return result;
        end
    end
    result["code"] = "000";
    result["nums"] = redis.call("INCR", ip);
    sleep(10);
    result["nums2"] = redis.call("GET", ip);
    redis.call("EXPIRE", ip, 1000);
    return result;
end

local ip = KEYS[1];
return cjson.encode(limit_ip_per_min(ip));

