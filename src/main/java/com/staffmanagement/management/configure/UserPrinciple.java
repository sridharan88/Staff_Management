// package com.staffmanagement.management.configure;

// import com.staffmanagement.management.model.Role;
// import java.util.Collection;
// import java.util.Collections;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;



// public class UserPrinciple implements UserDetails {


// @Autowired
// private Role role;

// public UserPrinciple(Role role){
//     super();
//     this.role=role;
// }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         // TODO Auto-generated method stub
//         return Collections.singleton(new SimpleGrantedAuthority(role.getRole())) ;
//     }

//     @Override
//     public String getPassword() {
//         // TODO Auto-generated method stub
//         return role.getPassword();
//     }

//     @Override
//     public String getUsername() {
//         // TODO Auto-generated method stub
//         return role.getUserName();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         // TODO Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         // TODO Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         // TODO Auto-generated method stub
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         // TODO Auto-generated method stub
//         return true;
//     }
    
// }
