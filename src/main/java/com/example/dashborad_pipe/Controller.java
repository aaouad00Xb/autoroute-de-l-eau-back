package com.example.dashborad_pipe;

import EmailDetailsService.EmailDetails;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.dashborad_pipe.Model.*;
import com.example.dashborad_pipe.Repo.AlbumRepo;
import com.example.dashborad_pipe.Repo.IhmRepo;
import com.example.dashborad_pipe.entities.*;
import com.example.dashborad_pipe.services.EmailService;
import com.example.dashborad_pipe.services.Service;
import com.example.dashborad_pipe.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class Controller {
    private IhmRepo ihmRepo;
    private Service service;
    private AlbumRepo albumRepo;

    private final UserService userService;

     private EmailService emailService;


    @Autowired
    public Controller(IhmRepo ihmRepo, Service service, AlbumRepo albumRepo, UserService userService, EmailService emailService) {
        this.ihmRepo = ihmRepo;
        this.service = service;
        this.albumRepo = albumRepo;
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> index(){
        List<Map<String, ?>> result = this.service.getprojectPhases();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/getphaseTable")
    public ResponseEntity<?> getphaseTable(){
        List<Phase> result = this.service.getphaseTable();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

@PostMapping(value = "/suprimer")
    public ResponseEntity<?> suprimer(@RequestBody Long id){
        this.service.suprimer(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping(value = "/getavancements")
    public ResponseEntity<?> getavancements(){

        return new ResponseEntity<>(this.service.getavancements(), HttpStatus.OK);
    }


    @GetMapping(value = "/alltasks")
    public ResponseEntity<?> alltasks(){
        List<Taskphase> result = this.service.alltasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }





@PostMapping(value = "/spliteF")
    public ResponseEntity<?> spliteF(@RequestBody ModelClass m){
    System.out.println(m);
        Integer result = this.service.spliteF(m.getId(), m.getPourcent());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping(value = "/updatephase")
    public ResponseEntity<?> updatephase(@RequestBody Phase m){
    System.out.println(m);
        service.updatephase(m);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/getGantt")
    public ResponseEntity<?> getGantt(@RequestBody Integer id){

        List<DataModel> dss = service.getGantt(id);
        return new ResponseEntity<>(dss,HttpStatus.OK);
    }


    @PostMapping(value = "/sendNotification")
    public ResponseEntity<?> sendNotification(@RequestBody String header){
        this.service.send_mail(header);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PostMapping(value = "/addTask")
    public ResponseEntity<?> addTask(@RequestBody TaskModel taskModel){
        System.out.println(taskModel);
        System.out.println("achraf ouad");
        service.addTask(taskModel);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/saveNotification")
    public ResponseEntity<?> saveNotification(@RequestBody List<Notification> notifications){

        System.out.println("achraf ouad");
        service.saveNotification(notifications);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PostMapping("/me")
    public ResponseEntity<?> returnMe(@RequestBody Long id){



      return   new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);
    }
    @PostMapping("/getUser")
    public ResponseEntity<?> getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorisqtionHeader = request.getHeader(AUTHORIZATION);
        if(authorisqtionHeader != null && authorisqtionHeader.startsWith("Bearer ")){
            try {
                String refreshToken = authorisqtionHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                MyUser user = userService.getUser(username);
                return new ResponseEntity<>(user,HttpStatus.OK);

            }catch (Exception e){

            }
        }else {
            throw new RuntimeException("refresh tocken is missing");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }



    @GetMapping("/Electriquevalues1")
    public ResponseEntity<?> Electriquevalues1(){
        return new ResponseEntity<>(this.service.Electriquevalues1(), HttpStatus.OK);
    }


    @PostMapping("/ElectriquevaluesSet")
    public ResponseEntity<?> ElectriquevaluesSet(@RequestBody Electriquevalues electriquevalues){
        return new ResponseEntity<>(this.service.ElectriquevaluesSet(electriquevalues), HttpStatus.OK);
    }
    @PostMapping("/user/save")
    public ResponseEntity<?> saveUser(@RequestBody MyUser user){
        this.userService.saveUser(user);
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

@GetMapping("getDivers")
public Divers getDivers(){
        return this.service.getDivers();
}

@PostMapping("saveDivers")
public Divers saveDivers(@RequestBody Divers divers){
        return this.service.saveDivers(divers);
}

    @PostMapping("/role/save")
    public ResponseEntity<?> saveRole(@RequestBody Role role){
        return new ResponseEntity<>(this.userService.saveRole(role), HttpStatus.OK);
    }
    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser){
        this.userService.addRoleToUser(roleToUser.getUserName(), roleToUser.getRoleName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        this.userService.getUsers();
        return new ResponseEntity<>(this.userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/getprofiles")
    public ResponseEntity<?> getprofiles(){

        return new ResponseEntity<>(this.service.getprofiles(),HttpStatus.OK);
    }

    @GetMapping("/getIhm")
    public ResponseEntity<?> getIhm(){

        return new ResponseEntity<>(this.service.getIhm(),HttpStatus.OK);
    }


    @PostMapping("/saveprofil")
    public ResponseEntity<?> saveprofil(@RequestBody Profil profil){
        System.out.println(profil);
        Set<Habilitation> habilitations = new HashSet<>();
        for(Habilitation h :profil.getHabilitations()){
            habilitations.add(Habilitation.builder().name(h.getName()).components(h.getComponents()).build());
        }
        Profil myProf = Profil.builder().name(profil.getName()).description(profil.getDescription()).dateAjout(profil.getDateAjout()).habilitations(habilitations).build();

        return new ResponseEntity<>(this.service.saveProfil(myProf),HttpStatus.OK);
    }


    @PostMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody MyUser myUser){
        System.out.println(myUser);
        return new ResponseEntity<>(this.userService.save(myUser),HttpStatus.OK);
    }

    @PostMapping("/updateTuy")
    public ResponseEntity<?> updateTuy(@RequestBody Tuyaux tuyaux){
        System.out.println(tuyaux);
        return new ResponseEntity<>(this.service.saveTuyoux(tuyaux),HttpStatus.OK);
    }

    @PostMapping("/savePompEvo")
    public ResponseEntity<?> savePompEvo(@RequestBody PompEvolution pompEvolution){
        System.out.println(pompEvolution);
        return new ResponseEntity<>(this.service.savePompEvo(pompEvolution),HttpStatus.OK);
    }

    @PostMapping("/saveMoteurEvo")
    public ResponseEntity<?> saveMoteurEvo(@RequestBody MoteurEvolution moteurEvolution){
        System.out.println(moteurEvolution);
        return new ResponseEntity<>(this.service.saveMoteurEvo(moteurEvolution),HttpStatus.OK);
    }

        @PostMapping("/saveElectriquEvol")
    public ResponseEntity<?> saveElectriquEvol(@RequestBody Electriquevolution electriquevolution){
        System.out.println(electriquevolution);
        return new ResponseEntity<>(this.service.saveElectriquEvol(electriquevolution),HttpStatus.OK);
    }

    @PostMapping("/savepElectrique")
    public ResponseEntity<?> savepElectrique(@RequestBody List<Electrique> electrique){





        this.service.savepElectrique(electrique);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/saveStation1")
    public ResponseEntity<?> saveStation1(@RequestBody List<Station_pomp1> station_pomp1s){
        System.out.println(station_pomp1s);
        this.service.saveStation1(station_pomp1s);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveStation1moteur")
    public ResponseEntity<?> saveStation1moteur(@RequestBody List<Station1Moteur> station_pomp1s){
        System.out.println(station_pomp1s);
        this.service.saveStation1moteur(station_pomp1s);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveStation2moteur")
    public ResponseEntity<?> saveStation2moteur(@RequestBody List<Station2Moteur> station_pomp1s){
        System.out.println(station_pomp1s);
        this.service.saveStation2moteur(station_pomp1s);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/saveStation2")
    public ResponseEntity<?> saveStation2(@RequestBody List<Station_pomp2> station_pomp2s){
        System.out.println(station_pomp2s);
        this.service.saveStation2(station_pomp2s);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/saveOuvrage")
    public ResponseEntity<?> saveOuvrage(@RequestBody List<Ouvrages_regulation> ouvrages_regulations){
        System.out.println(ouvrages_regulations);
        this.service.saveOuvrage(ouvrages_regulations);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveOuvrageMoteur")
    public ResponseEntity<?> saveOuvrageMoteur(@RequestBody List<OuvrageRegulationMoteur> ouvrages_regulations){
        System.out.println(ouvrages_regulations);
        this.service.saveOuvrageMoteur(ouvrages_regulations);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/savePomp")
    public ResponseEntity<?> savePomp(@RequestBody Pomp pomp){
        System.out.println(pomp);
        this.service.savePomp(pomp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveMoteur")
    public ResponseEntity<?> saveMoteur(@RequestBody Moteur moteur){
        System.out.println(moteur);
        this.service.saveMoteur(moteur);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getPomp")
    public ResponseEntity<?> getPomp(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getPomp(),HttpStatus.OK);
    }

    @GetMapping("/getMoteur")
    public ResponseEntity<?> getMoteur(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getMoteur(),HttpStatus.OK);
    }

    @GetMapping("/getFinanacement")
    public ResponseEntity<?> getFinanacement(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getFinanacement(),HttpStatus.OK);
    }




    @PostMapping("/updateTerr")
    public ResponseEntity<?> updateTerr(@RequestBody Terassement terassement){




        System.out.println(terassement);
        return new ResponseEntity<>(this.service.saveTerassement(terassement),HttpStatus.OK);
    }

    @GetMapping("/getTuyItemToEdit")
    public ResponseEntity<?> getTuyItemToEdit(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getTuyItemToEdit(),HttpStatus.OK);
    }
@GetMapping("/getActions")
    public ResponseEntity<?> getActions(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getActions(),HttpStatus.OK);
    }

    @GetMapping("/getPompItemToEdit")
    public ResponseEntity<?> getPompItemToEdit(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getPompItemToEdit(),HttpStatus.OK);
    }

   @GetMapping("/getElectriqueItemToEdit")
    public ResponseEntity<?> getElectriqueItemToEdit(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getElectriqueItemToEdit(),HttpStatus.OK);
    }

    @GetMapping("/notification_content")
    public ResponseEntity<?> notification_content(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.notification_content(),HttpStatus.OK);
    }




    @PostMapping("/saveNotification_content")
    public ResponseEntity<?> saveNotification_content(@RequestBody Notification_content notification_content){
        return new ResponseEntity<>(this.service.saveNotification_content(notification_content),HttpStatus.OK);
    }



    @PostMapping("/getTuyItemToEditByDate")
    public ResponseEntity<?> getTuyItemToEditByDate(@RequestBody Date date){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getTuyItemToEditByDate(date),HttpStatus.OK);
    }


    @GetMapping("/getstation1")
    public ResponseEntity<?> getstation1(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getstation1(),HttpStatus.OK);
    }

    @GetMapping("/getstation1Moteur")
    public ResponseEntity<?> getstation1Moteur(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getstation1Moteur(),HttpStatus.OK);
    }

 @GetMapping("/getstation2Moteur")
    public ResponseEntity<?> getstation2Moteur(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getstation2Moteur(),HttpStatus.OK);
    }


    @GetMapping("/getstation2")
    public ResponseEntity<?> getstation2(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getstation2(),HttpStatus.OK);
    }

    @GetMapping("/getOuvrage")
    public ResponseEntity<?> getOuvrage(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getOuvrage(),HttpStatus.OK);
    }

    @GetMapping("/getOuvrageMoteur")
    public ResponseEntity<?> getOuvrageMoteur(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getOuvrageMoteur(),HttpStatus.OK);
    }

    @GetMapping("/getTerrItemToEdit")
    public ResponseEntity<?> getTerrItemToEdit(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getTerrItemToEdit(),HttpStatus.OK);
    }
    @GetMapping("/getMoteurItemToEdit")
    public ResponseEntity<?> getMoteurItemToEdit(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getMoteurItemToEdit(),HttpStatus.OK);
    }

    @GetMapping("/getTuyItemSynth")
    public ResponseEntity<?> getTuyItemSynth(){
        //todo
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getTuyItemSynth(),HttpStatus.OK);
    }
    @GetMapping("/getElectriqueItemSynth")
    public ResponseEntity<?> getElectriqueItemSynth(){
        System.out.println("achraf456");
        System.out.println(this.service.getElectriqueItemSynth());
        return new ResponseEntity<>(this.service.getElectriqueItemSynth(),HttpStatus.OK);
    }

    @GetMapping("/getPompEvolutioneItemSynth")
    public ResponseEntity<?> getPompEvolutioneItemSynth(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getPompEvolutioneItemSynth(),HttpStatus.OK);
    }


    @GetMapping("/getMoteurEvolutioneItemSynth")
    public ResponseEntity<?> getMoteurEvolutioneItemSynth(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getMoteurEvolutioneItemSynth(),HttpStatus.OK);
    }

    @GetMapping("/getvalidaton1Tuyoux")
    public ResponseEntity<?> getvalidaton1Tuyoux(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getvalidaton1Tuyoux(),HttpStatus.OK);
    }
    @GetMapping("/getvalidaton2Tuyoux")
    public ResponseEntity<?> getvalidaton2Tuyoux(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getvalidaton2Tuyoux(),HttpStatus.OK);
    }

    @GetMapping("/getEvolutionTuyaux")
    public ResponseEntity<?> getEvolutionTuyaux(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getEvolutionTuyaux(),HttpStatus.OK);
    }


    @GetMapping("/getDates")
    public ResponseEntity<?> getDates(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getDates(),HttpStatus.OK);
    }

    @GetMapping("/getDatesForce")
    public ResponseEntity<?> getDatesForce(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getDatesForce(),HttpStatus.OK);
    }


    @GetMapping("/getElectrique")
    public ResponseEntity<?> getElectrique(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getElectrique(),HttpStatus.OK);
    }

    @GetMapping("/gettingAllTerrassement")
    public ResponseEntity<?> gettingAllTerrassement(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.gettingAllTerrassement(),HttpStatus.OK);
    }
    @GetMapping("/getTraversees")
    public ResponseEntity<?> getTraversees(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.getTraversees(),HttpStatus.OK);
    }


    @GetMapping("/gettingAllAlbumes")
    public ResponseEntity<?> gettingAllAlbumes(){
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.gettingAllAlbumes(),HttpStatus.OK);
    }



  @PostMapping("/saveTraverse")
    public ResponseEntity<?> saveTraverse(@RequestBody List<Traversees> tr){
        System.out.println("achraf");
      this.service.saveTraverse(tr);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/saveFinancement")
    public ResponseEntity<?> saveFinancement(@RequestBody List<Financement> tr){
        System.out.println("achraf");
      this.service.saveFinancement(tr);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveAlbum")
    public ResponseEntity<?> saveAlbum(@RequestBody String name) {
        System.out.println("achraf");
        return new ResponseEntity<>(this.service.saveAlbum(name), HttpStatus.OK);
    }
    @PostMapping("/saveParentAlbum")
    public ResponseEntity<?> saveParentAlbum(@RequestBody String name) {

        return new ResponseEntity<>(this.service.saveAlbum(name), HttpStatus.OK);
    }

    @PostMapping("/savesubAlbum")
    public ResponseEntity<?> savesubAlbum(@RequestBody Album album) {

        Album shild_album= this.albumRepo.save(Album.builder().name(album.getName()).parent(false).build());
        Album album1 = this.albumRepo.findById(album.getId_album()).get();
        if(album1.getSubAlbums()!=null){
            album1.getSubAlbums().add(shild_album);
        }else{
            Set<Album> albums = new HashSet<>();
            albums.add(shild_album);
        }
        return new ResponseEntity<>(this.albumRepo.save(album1), HttpStatus.OK);
    }


    @GetMapping("/getParentAlbums")
    public ResponseEntity<?> getParentAlbums() {
        return new ResponseEntity<>(this.service.getParents(), HttpStatus.OK);
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadImageFile(@RequestParam(required = false, name = "file") MultipartFile file, @RequestParam("name") String name, @RequestParam("comment") String comment, @RequestParam("id") String id) throws IOException {

        Long id2 = Long.parseLong(id);
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(comment);

        String path = new ClassPathResource("static/images/").getFile().getAbsolutePath();
        System.out.println(path);

        Album album = albumRepo.findById(id2).get();

        if (file != null) {
            Files.copy(file.getInputStream(), Paths.get(path + File.separator + name+".jpg"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(name);
        }

        if (file != null) {


            String image = "images/" + name+".jpg";

            if (album.getImages() != null) {
                album.getImages().add(image);
            }else {
                List<String> images = new ArrayList<>();
                images.add(image);
                album.setImages(images);
            }

            System.out.println("hello mother fucker");

            return new ResponseEntity<>(this.service.updateAlbum(album), HttpStatus.OK);
        }




        ErrorResponse errorResponse = ErrorResponse.builder().build();
        errorResponse.setMessage("somthing goes wrong");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }



//    @GetMapping("/TuyauxSituationSemaine")
//    public ResponseEntity<?> TuyauxSituationSemaine(){
//
//        return new ResponseEntity<>(this.service.TuyauxSituationSemaine(),HttpStatus.OK);
//    }


    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);
        return status;
    }

    @PostMapping("/sendMailProfile")
    public void
    sendMailProfile(@RequestBody MessageProf messageProf)
    {
        System.out.println(messageProf);
        EmailDetails emailDetails = EmailDetails.builder().msgBody(messageProf.getContent()).subject(messageProf.getIntitule()).build();
        for(MyUser ele : this.userService.getUsers()){
            if(ele.getProfil()!= null){
                System.out.println(ele);
                if(Objects.equals(ele.getProfil().getId_prof(), messageProf.getId_prof())){
                    System.out.println(ele.getProfil().getId_prof() );

                    if(ele.getEmail()!= null) {
                       emailDetails.setRecipient(ele.getEmail());
                      String status = emailService.sendSimpleMail(emailDetails);
                       System.out.println(status);
                   }

                }
            }
        }

    }


    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }



}



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class RoleToUser {
    private String userName;
    private String roleName;
}




