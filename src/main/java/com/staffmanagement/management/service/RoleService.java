package com.staffmanagement.management.service;

// import com.staffmanagement.management.configure.UserPrinciple;
import com.staffmanagement.management.model.Role;
import com.staffmanagement.management.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoleService  {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role roles) {

        if(roles.role==null){
            roles.role="STAFF";
        return roleRepository.save(roles);
        }else{
            roles.role="ADMIN";
            return roleRepository.save(roles);
        }

    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public void deleteRoleNo(int no) {

        roleRepository.deleteById(no);
    }

    // @Override
    // public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    //     Role user = roleRepository.findByUserName(userName);
    //     if (user == null) {
    //         throw new UsernameNotFoundException("user 404 Not Found");
    //     }
    //     //return new UserPrinciple(user);
    //     return null;
    // }
}
