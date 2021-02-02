package fb;

public class ValidateIpAddress {
    public String validIPAddress(String IP) {
        if(IP.contains("."))  {
            return validateIpv4(IP);
        } else {
            return validateIpv6(IP);
        }
    }

    private String validateIpv4(String ip) {
        String[] parts = ip.split("\\.");
        if(parts.length != 4) {
            return "Neither";
        }
        if(ip.charAt(ip.length() - 1) == '.') {
            return "Neither";
        }
        for(String part: parts) {
            if(part.length() == 0) return "Neither";
            try {
                int value = Integer.parseInt(part);
                if(value < 0 || value > 255) return "Neither";
            } catch (Exception e) {
                return "Neither";
            }
            if(part.length() > 1) {
                if(part.charAt(0) == '0') return "Neither";
            }
        }
        return "IPv4";
    }

    private String validateIpv6(String ip) {
        String[] parts = ip.split(":");
        if(parts.length != 8) {
            return "Neither";
        }
        if(ip.charAt(ip.length() - 1) == ':') {
            return "Neither";
        }
        for(String part: parts) {
            if(part.length() < 1 || part.length() > 4) return "Neither";
            for(int i = 0; i < part.length(); i++) {
                char ch = part.charAt(i);
                if(ch >= '0' && ch <= '9') {
                    // ok
                } else if (ch >= 'a' && ch <= 'f') {
                    // ok
                } else if (ch >= 'A' && ch <= 'F') {
                    // ok
                } else {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
