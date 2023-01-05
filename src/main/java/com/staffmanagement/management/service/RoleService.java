package com.staffmanagement.management.service;

// import com.staffmanagement.management.configure.UserPrinciple;
import com.staffmanagement.management.model.Role;
import com.staffmanagement.management.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Role> updateById(int no, Role role) {
        Optional<Role> roleId=roleRepository.findById(no);
        if(roleId.isPresent()){
            Role roleUpdate=roleId.get();
            roleUpdate.setEmail(role.getEmail());
            roleUpdate.setName(role.getName());
            roleUpdate.setPassword(role.getPassword());
            roleUpdate.setRole(role.getRole());
            return new ResponseEntity<>(roleRepository.save(roleUpdate),HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
