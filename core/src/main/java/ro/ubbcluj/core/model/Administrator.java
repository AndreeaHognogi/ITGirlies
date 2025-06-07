//package ro.ubbcluj.core.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//@ToString
//public class Administrator extends BaseEntity<Long>{
//
//    @Column(name = "nume", nullable = false)
//    private String nume;
//
//    @Column(name = "phone", nullable = false)
//    private String phone;
//
//    @Column(name = "email", nullable = false)
//    private String email;
//
//    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Cerere> cereri= new HashSet<>();
//
//    public Administrator(Long id) {
//        super(id);
//    }
//
////    public Set<Locatar> getLocatari() {
////        cereri = cereri == null ? new HashSet<>() :
////                cereri;
////        return Collections.unmodifiableSet(
////                this.cereri.stream().
////                        map(Cerere::getLocatar).
////                        collect(Collectors.toSet()));
////    }
//}
