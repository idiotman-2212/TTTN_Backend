package com.tttnbackend.tttnbackend.entity.enumType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
@NoArgsConstructor
@AllArgsConstructor
public enum RoleCode {
    ROLE_ADMIN("Quản trị viên"),
    ROLE_STAFF("Nhân viên"),
    ROLE_CUSTOMER("Khách hàng"),
    ROLE_CREATE("Tạo mới"),
    ROLE_READ("Đọc"),
    ROLE_UPDATE("Cập nhật"),
    ROLE_DELETE("Xóa");

    String name;
}
