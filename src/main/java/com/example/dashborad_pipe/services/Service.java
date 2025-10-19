package com.example.dashborad_pipe.services;

import EmailDetailsService.EmailDetails;
import com.example.dashborad_pipe.Model.*;
import com.example.dashborad_pipe.Repo.*;
import com.example.dashborad_pipe.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    private Ouvrages_regulationRepo ouvrages_regulationRepo;
    private String ip;
    private EmailService emailService;
    private UserRepository userRepo;
    private ActionRepo actionRepo;
    private ElectriquevaluesRepo electriquevaluesRepo;
    private PompRepo pompRepo;
    private Station_pomp1Repo station_pomp1Repo;

    private Station1MoteurRepo station1MoteurRepo;
    private Station2MoteurRepo station2MoteurRepo;
    private Ouvrages_regulation_moteur_Repo ouvrages_regulation_moteur_repo;
    private Station_pomp2Repo station_pomp2Repo;
    private ElectriqueRepo electriqueRepo;
    private ProjetRepository projetRepository;
    private TraverseesRepo traverseesRepo;
    private AlbumRepo albumRepo;
    private PhaseRepository phaseRepository;
    private TaskphaseRepo taskphaseRepo;
    private ProfileRepository profilRepository;
    private NotificationRepo notificationRepo;
    private IhmRepo ihmRepo;
    private MoteurRepo moteurRepo;
    private FinancementRepo financementRepo;
    private TuyouxRepo tuyouxRepo;
    private PrevuTuyouRepo prevuTuyouRepo;
    private ReelTutouxRepo reelTutouxRepo;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private Prevu_Terrassement_Repo prevu_terrassement_repo;
    private Reel_Terrassement_Repo reel_terrassement_repo;
    private final UserService userService;
    private TerrassementRepo terrassementRepo;
    private PelectriqueRepo pelectriqueRepo;
    private Notification_content_repo notification_content_repo;

    private AvancementRepo avancementRepo;
private ElectriqueEvolutionRepo electriqueEvolutionRepo;
private PompEvoRepo pompEvoRepo;
private MoteurEvoRepo MoteurEvoRepo ;
    private DiversRepo diversRepo;

    @Autowired
    public Service(Ouvrages_regulationRepo ouvrages_regulationRepo, EmailService emailService, UserRepository userRepo, ActionRepo actionRepo, ElectriquevaluesRepo electriquevaluesRepo, PompRepo pompRepo, Station_pomp1Repo station_pomp1Repo, Station1MoteurRepo station1MoteurRepo, Station2MoteurRepo station2MoteurRepo, Ouvrages_regulation_moteur_Repo ouvrages_regulation_moteur_repo, Station_pomp2Repo station_pomp2Repo, ElectriqueRepo electriqueRepo, ProjetRepository projetRepository, TraverseesRepo traverseesRepo, AlbumRepo albumRepo, PhaseRepository phaseRepository, TaskphaseRepo taskphaseRepo, ProfileRepository profilRepository, IhmRepo ihmRepo, NotificationRepo notificationRepo, MoteurRepo moteurRepo, FinancementRepo financementRepo, TuyouxRepo tuyouxRepo, UserService userService, PrevuTuyouRepo prevuTuyouRepo, ReelTutouxRepo reelTutouxRepo, Prevu_Terrassement_Repo prevu_terrassement_repo, Reel_Terrassement_Repo reel_terrassement_repo, TerrassementRepo terrassementRepo, PelectriqueRepo pelectriqueRepo, Notification_content_repo notification_content_repo, AvancementRepo avancementRepo, PompEvoRepo pompEvoRepo, ElectriqueEvolutionRepo electriqueEvolutionRepo, MoteurEvoRepo moteurEvoRepo, DiversRepo diversRepo) {
        this.ouvrages_regulationRepo = ouvrages_regulationRepo;
        this.emailService = emailService;
        this.userRepo = userRepo;
        this.actionRepo = actionRepo;
        this.electriquevaluesRepo = electriquevaluesRepo;
        this.pompRepo = pompRepo;
        this.station_pomp1Repo = station_pomp1Repo;
        this.station1MoteurRepo = station1MoteurRepo;
        this.station2MoteurRepo = station2MoteurRepo;
        this.ouvrages_regulation_moteur_repo = ouvrages_regulation_moteur_repo;
        this.station_pomp2Repo = station_pomp2Repo;
        this.electriqueRepo = electriqueRepo;
        this.projetRepository = projetRepository;
        this.traverseesRepo = traverseesRepo;
        this.albumRepo = albumRepo;
        this.phaseRepository = phaseRepository;
        this.taskphaseRepo = taskphaseRepo;
        this.profilRepository = profilRepository;
        this.ihmRepo = ihmRepo;
        this.notificationRepo = notificationRepo;
        this.moteurRepo = moteurRepo;
        this.financementRepo = financementRepo;
        this.tuyouxRepo = tuyouxRepo;
        this.userService = userService;
        this.prevuTuyouRepo = prevuTuyouRepo;

        this.reelTutouxRepo = reelTutouxRepo;
        this.prevu_terrassement_repo = prevu_terrassement_repo;
        this.reel_terrassement_repo = reel_terrassement_repo;
        this.terrassementRepo = terrassementRepo;

        this.pelectriqueRepo = pelectriqueRepo;
        this.notification_content_repo = notification_content_repo;
        this.avancementRepo = avancementRepo;
        this.pompEvoRepo = pompEvoRepo;
        this.electriqueEvolutionRepo = electriqueEvolutionRepo;
        this.MoteurEvoRepo = moteurEvoRepo;
        this.diversRepo = diversRepo;
    }


    public List<Map<String, ?>> getprojectPhases() {
        List<Map<String, ?>> ls = phaseRepository.getprojectPhases();

        ls.forEach(System.out::println);
        return ls;
    }

    public List<Phase> getphaseTable() {
        return phaseRepository.findAll();


    }
    public void suprimer(Long id) {
        avancementRepo.suprimer(id);
        avancementRepo.suprimer2(id);



    }

    public List<Map<String,?>> getavancements() {
        List<Map<String,?>> ls = phaseRepository.getavancements();

        ls.forEach(System.out::println);
        return ls;
    }

    public List<Taskphase> alltasks() {
        List<Taskphase> ls = taskphaseRepo.findAll();

        return ls;
    }

public Divers getDivers() {
    System.out.println(this.diversRepo.findAll().get(0));
        return this.diversRepo.findAll().get(0);
    }

public Divers saveDivers(Divers divers) {

        return this.diversRepo.save(divers);
    }

    public List<Station_pomp1> getstation1() {


        return station_pomp1Repo.findAll();
    }

public List<Station1Moteur> getstation1Moteur() {


        return station1MoteurRepo.findAll();
    }

    public List<Station2Moteur> getstation2Moteur() {


        return station2MoteurRepo.findAll();
    }


    public List<Station_pomp2> getstation2() {

        return station_pomp2Repo.findAll();

    }

    public List<Ouvrages_regulation> getOuvrage() {


        return ouvrages_regulationRepo.findAll();
    }

    public List<OuvrageRegulationMoteur> getOuvrageMoteur() {


        return ouvrages_regulation_moteur_repo.findAll();
    }

    public Integer spliteF(Integer id, Double pourcent) {
        Integer ls = phaseRepository.spliteF(id, pourcent);


        return ls;
    }

    public List<Traversees> getTraversees() {
      return this.traverseesRepo.findAll();
    }

    public void addTask(TaskModel m) {
        Phase p = phaseRepository.findPhaseById(m.getPhase());
        taskphaseRepo.save(Taskphase.builder().version(m.getVersion()).phase(p).date_depart(m.getDate_depart()).predecessors(m.getPred()).date_arrive(m.getDate_arrive()).id(m.getId()).name(m.getName()).build());

    }

  public void saveNotification(List<Notification> m) {
        for(Notification n : m){
            this.notificationRepo.save(n);
        }

    }

    public List<DataModel> getGantt(Integer id) {
        List<Taskphase> p = this.taskphaseRepo.findAll();

        String array[] = new String[]{"init", "updated"};
        List<DataModel> dss = new ArrayList<>();

//        for (String vers : array) {
//            DataModel ds = new DataModel();
//            ds.setName(vers);
//            for (Taskphase ph : p) {
//                if (ph.getPhase().getId() == id) {
//                    if (ph.getVersion().equals(vers)) {
//                        CoordinateGantt crrd = new CoordinateGantt();
//
//                        crrd.setX(ph.getName());
//                        crrd.setId(ph.getId().toString());
//                        crrd.setY(List.of(ph.getDate_depart(), ph.getDate_arrive()));
//                        crrd.setPedecessors(ph.getPredecessors());
//                        ds.getData().add(crrd);
//                    }
//                }
//            }
//            dss.add(ds);
//        }

        return dss;
    }

    public void updatephase(Phase m) {
        phaseRepository.save(m);


    }


//    tasing

    public static class Task {
        //the actual cost of the task
        public int cost;
        //the cost of the task along the critical path
        public int criticalCost;
        //a name for the task for printing
        public String name;
        //the tasks on which this task is dependant
        public HashSet<CriticalPath.Task> dependencies = new HashSet<CriticalPath.Task>();

        public Task(String name, int cost, CriticalPath.Task... dependencies) {
            this.name = name;
            this.cost = cost;
            for (CriticalPath.Task t : dependencies) {
                this.dependencies.add(t);
            }
        }

        @Override
        public String toString() {
            return name + ": " + criticalCost;
        }

        public boolean isDependent(CriticalPath.Task t) {
            //is t a direct dependency?
            if (dependencies.contains(t)) {
                return true;
            }
            //is t an indirect dependency
            for (CriticalPath.Task dep : dependencies) {
                if (dep.isDependent(t)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static CriticalPath.Task[] criticalPath(Set<CriticalPath.Task> tasks) {
        //tasks whose critical cost has been calculated
        HashSet<CriticalPath.Task> completed = new HashSet<CriticalPath.Task>();
        //tasks whose ciritcal cost needs to be calculated
        HashSet<CriticalPath.Task> remaining = new HashSet<CriticalPath.Task>(tasks);

        //Backflow algorithm
        //while there are tasks whose critical cost isn't calculated.
        while (!remaining.isEmpty()) {
            boolean progress = false;

            //find a new task to calculate
            for (Iterator<CriticalPath.Task> it = remaining.iterator(); it.hasNext(); ) {
                CriticalPath.Task task = it.next();
                if (completed.containsAll(task.dependencies)) {
                    //all dependencies calculated, critical cost is max dependency
                    //critical cost, plus our cost
                    int critical = 0;
                    for (CriticalPath.Task t : task.dependencies) {
                        if (t.criticalCost > critical) {
                            critical = t.criticalCost;
                        }
                    }
                    task.criticalCost = critical + task.cost;
                    //set task as calculated an remove
                    completed.add(task);
                    it.remove();
                    //note we are making progress
                    progress = true;
                }
            }
            //If we haven't made any progress then a cycle must exist in
            //the graph and we wont be able to calculate the critical path
            if (!progress) throw new RuntimeException("Cyclic dependency, algorithm stopped!");
        }

        //get the tasks
        CriticalPath.Task[] ret = completed.toArray(new CriticalPath.Task[0]);
        //create a priority list
        Arrays.sort(ret, new Comparator<CriticalPath.Task>() {

            @Override
            public int compare(CriticalPath.Task o1, CriticalPath.Task o2) {
                //sort by cost
                int i = o2.criticalCost - o1.criticalCost;
                if (i != 0) return i;

                //using dependency as a tie breaker
                //note if a is dependent on b then
                //critical cost a must be >= critical cost of b
                if (o1.isDependent(o2)) return -1;
                if (o2.isDependent(o1)) return 1;
                return 0;
            }
        });

        return ret;
    }

    public List<Ihm> getIhm() {
        return this.ihmRepo.findAll();
    }


    public Tuyaux saveTuyoux(Tuyaux tuyaux) {
  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("tuyaux").befor(this.getTuyItemToEdit().toString()).after(tuyaux.toString()).ipAdress(ip).build());
        Tuyaux previewt =  this.tuyouxRepo.findById(tuyaux.getId_tuyaux()).get();
        System.out.println(previewt);
        if(previewt.getReel_tuyaux() == null){
            previewt.setReel_tuyaux(Reel_tuyaux.builder().build());
        }
        System.out.println(tuyaux);
        System.out.println(getformatedDate(previewt.getPrevu_tuyaux().getDepart_usine()));
        System.out.println(getformatedDate(previewt.getPrevu_tuyaux().getDepart_usine()));
        System.out.println(getformatedDate(previewt.getReel_tuyaux().getSortie_port_Casa()));

        Prevu_tuyaux p = this.prevuTuyouRepo.save(tuyaux.getPrevu_tuyaux());
        Reel_tuyaux r = this.reelTutouxRepo.save(tuyaux.getReel_tuyaux());
        tuyaux.setReel_tuyaux(r);
        tuyaux.setPrevu_tuyaux(p);
        return this.tuyouxRepo.save(tuyaux);
    }



    public String getformatedDate(Date d){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if(d != null){
            return  formatter.format(d);

        }
        return "-----";
    }

    public PompEvolution savePompEvo(PompEvolution pompEvolution) {
        this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("pompEvolution").befor(this.getPompItemToEdit().toString()).after(pompEvolution.toString()).ipAdress(ip).build());

        return this.pompEvoRepo.save(pompEvolution);
    }


    public MoteurEvolution saveMoteurEvo(MoteurEvolution moteurEvolution) {
        this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("MoteurEvolution").befor(this.getMoteurItemToEdit().toString()).after(moteurEvolution.toString()).ipAdress(ip).build());

        return this.MoteurEvoRepo.save(moteurEvolution);
    }




    public Electriquevolution saveElectriquEvol(Electriquevolution electriquevolution) {

//        EmailDetails emailDetails = EmailDetails.builder().subject("Demande de changement de valeurs des tuyaux")
//                .msgBody(
//""
//
//                )
//                .recipient("achraf.aouad@etu.uae.ac.ma").build();
        this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("Electriquevolution").befor(this.getElectriqueItemToEdit().toString()).after(electriquevolution.toString()).ipAdress(ip).build());

        return this.electriqueEvolutionRepo.save(electriquevolution);
    }
    public void savepElectrique(List<Electrique> electrique) {




        for(Electrique ele : electrique){

            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("electrique").befor(this.pelectriqueRepo.findById(ele.getId_ele()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.pelectriqueRepo.save(ele);
        }

    }

    public void saveStation1(List<Station_pomp1> station_pomp1s) {


//todo





        for(Station_pomp1 ele : station_pomp1s){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("station_pomp1").befor(this.station_pomp1Repo.findById(ele.getId_pomp()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.station_pomp1Repo.save(ele);
        }
    }


    public void saveStation1moteur(List<Station1Moteur> station_pomp1s) {

        for(Station1Moteur ele : station_pomp1s){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("station_pomp1").befor(this.station_pomp1Repo.findById(ele.getId_pomp()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.station1MoteurRepo.save(ele);
        }
    }


    public void saveStation2moteur(List<Station2Moteur> station_pomp1s) {

        for(Station2Moteur ele : station_pomp1s){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("station_pomp1").befor(this.station_pomp1Repo.findById(ele.getId_pomp()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.station2MoteurRepo.save(ele);
        }
    }
    public void saveStation2(List<Station_pomp2> station_pomp1s) {



        for(Station_pomp2 ele : station_pomp1s){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("station_pomp2").befor(this.station_pomp2Repo.findById(ele.getId_pomp()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.station_pomp2Repo.save(ele);
        }

    }
    public void saveOuvrage(List<Ouvrages_regulation> ouvrages_regulations) {



        for(Ouvrages_regulation ele : ouvrages_regulations){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("saveOuvrage").befor(this.ouvrages_regulationRepo.findById(ele.getId_ov()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.ouvrages_regulationRepo.save(ele);
        }

    }

    public void saveOuvrageMoteur(List<OuvrageRegulationMoteur> ouvrages_regulations) {



        for(OuvrageRegulationMoteur ele : ouvrages_regulations){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("saveOuvrage").befor(this.ouvrages_regulationRepo.findById(ele.getId_ov()).toString()).after(ele.toString()).ipAdress(ip).build());

            this.ouvrages_regulation_moteur_repo.save(ele);
        }

    }

 public void savePomp(Pomp pomp) {

     Pomp eess = pompRepo.findAll().get(0);



            this.pompRepo.save(pomp);

    }


    public void saveMoteur(Moteur moteur) {

     Moteur eess = moteurRepo.findAll().get(0);



            this.moteurRepo.save(moteur);

    }

    public Pomp getPomp() {


           return this.pompRepo.findAll().get(0);

    }

    public Moteur getMoteur () {

           return this.moteurRepo.findAll().get(0);

    }
public List<Financement> getFinanacement() {


           return this.financementRepo.findAll();

    }


    public Terassement saveTerassement(Terassement terassement) {
        Terassement terassement1 = terrassementRepo.findAll().get(0);


        Prevu_Terrassement p = this.prevu_terrassement_repo.save(terassement.getPrevu_terrassement());
        Reel_Terrassement r = this.reel_terrassement_repo.save(terassement.getReel_terrassement());
        terassement.setPrevu_terrassement(p);
        terassement.setReel_terrassement(r);
        this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("saveTerassement").befor(this.terrassementRepo.findById(terassement.getId_Ter()).toString()).after(terassement.toString()).ipAdress(ip).build());

        return this.terrassementRepo.save(terassement);
    }

    public List<Tuyaux>  getvalidaton1Tuyoux() {
        List<Tuyaux> tuyauxes =new ArrayList<>();
        Date now = new Date();
        for (Tuyaux lt : this.tuyouxRepo.findAll()) {
            if(  lt.getInputDate() != null && lt.getValidation1() == null && lt.getValidation2() == null){
                tuyauxes.add(lt);
            }
        }

        return tuyauxes;
    }

    public List<Tuyaux>  getvalidaton2Tuyoux() {
        List<Tuyaux> tuyauxes =new ArrayList<>();
        Date now = new Date();
        for (Tuyaux lt : this.tuyouxRepo.findAll()) {
            if(  lt.getValidation1() != null && lt.getValidation2() == null){
                tuyauxes.add(lt);
            }
        }

        return tuyauxes;
    }

public List<Terassement> gettingAllTerrassement(){
        return this.terrassementRepo.gettingAllTerrassement();
}

public List<Album> gettingAllAlbumes(){
        return this.albumRepo.findAll();
}


    public Album saveAlbum(String name){
        return this.albumRepo.save(Album.builder().name(name).parent(true).build());
    }
    public void saveTraverse(List<Traversees> tr){


        for(Traversees tre:tr){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("saveTraverse").befor(this.traverseesRepo.findById(tre.getId_traversees()).toString()).after(tre.toString()).ipAdress(ip).build());
//todo
            this.traverseesRepo.save(tre);
        }

    }


    public void saveFinancement(List<Financement> tr){


        for(Financement tre:tr){
            this.actionRepo.save(Actions.builder().actioner((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).time(new Date()).cibledData("saveFinancement").befor(this.financementRepo.findById(tre.getId()).toString()).after(tre.toString()).ipAdress(ip).build());

            this.financementRepo.save(tre);
        }

    }

    public Album updateAlbum(Album album){
        return this.albumRepo.save(album);
    }

    public List<Album> getParents(){
        List<Album> ls = new ArrayList<>();
        for(Album al: this.albumRepo.findAll()){
            System.out.println(al);
            if(al.getParent()){
                ls.add(al);
            }
        }
        return ls;
    }


    public List<Date> getDates(){
        List<Date> ls = new ArrayList<>();

        for (Tuyaux lt : this.tuyouxRepo.orderBydate()) {

            if((lt.getValidation1() != null && lt.getValidation2()!= null) || lt.getInputDate() == null){

                    ls.add(lt.getDate());


                }
            }
        return ls;
        }

    public List<Date> getDatesForce(){
        List<Date> ls = new ArrayList<>();

        for (Tuyaux lt : this.tuyouxRepo.orderBydate()) {



                ls.add(lt.getDate());


        }
        return ls;
    }

    public Electriquevalues Electriquevalues1(){
        return this.electriquevaluesRepo.findAll().get(0);
    }

    public Electriquevalues ElectriquevaluesSet(Electriquevalues elec){
        Electriquevalues eess = electriquevaluesRepo.findAll().get(0);


        return this.electriquevaluesRepo.save(elec);
    }

    public List<TuyauxSerieItem>  getEvolutionTuyaux()
    {
        List<TuyauxSerieItem> tuyauxes =new ArrayList<>();
        List<String> typo = new ArrayList<>();
        typo.add("prévision");
        typo.add("Actuel");
        typo.add("programmé");

        Double currentprevValue = 0D;
        Double currentprevValue1 = 0D;


        for(String ele: typo){

            TuyauxSerieItem tuyauxSerieItem = TuyauxSerieItem.builder().build();
            tuyauxSerieItem.setType("line");
            tuyauxSerieItem.setName(ele);
            Emphasis emphasis = Emphasis.builder().focus("series").build();
            tuyauxSerieItem.setEmphasis(emphasis);
            if(ele.equals("prévision")){

                LineStyle lineStyle = LineStyle.builder().width(5).shadowColor("rgba(0,0,0,0.3)").shadowBlur(6).shadowOffsetY(6).color("red").build();
                List<Data1> data1s = new ArrayList<>();
                data1s.add(Data1.builder().type("max").name("Max").build());
                MarkPoint markPoint = MarkPoint.builder().data(data1s).build();
                tuyauxSerieItem.setLineStyle(lineStyle);
                tuyauxSerieItem.setMarkPoint(markPoint);
            }else if(ele.equals("Actuel")){
                LineStyle lineStyle = LineStyle.builder().width(5).shadowColor("rgba(0,0,0,0.3)").shadowBlur(6).shadowOffsetY(6).build();
                List<Data1> data1s = new ArrayList<>();
                data1s.add(Data1.builder().type("max").name("Max").build());
                MarkPoint markPoint = MarkPoint.builder().data(data1s).build();
                tuyauxSerieItem.setLineStyle(lineStyle);
                tuyauxSerieItem.setMarkPoint(markPoint);
            }
            else if(ele.equals("programmé")){
                LineStyle lineStyle = LineStyle.builder().width(5).shadowColor("rgba(0,0,0,0.3)").shadowBlur(6).shadowOffsetY(6).build();
                tuyauxSerieItem.setLineStyle(lineStyle);
            }
            List<Double> datas = new ArrayList<>();
            for (Tuyaux lt : this.tuyouxRepo.orderBydate()) {
//                System.out.println(lt);
                if(lt.getValidation1() != null && lt.getValidation2()!= null || lt.getInputDate() == null){


                if(lt.getReel_tuyaux()!= null) {
//                    System.out.println(lt);
//                    System.out.println("hahowa dialna");
//                    System.out.println(getTuyItemSynth());

                    if (ele.equals("Actuel") && lt.getReel_tuyaux().getApprovionnement_sur_chantier_et_bardage() != null && lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage() != null) {

                        datas.add(lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage());
                    }else if(ele.equals("Actuel") && (lt.getReel_tuyaux().getApprovionnement_sur_chantier_et_bardage() == null || lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage() == null)){
                        datas.add(null);
                    }

                }
                    if (ele.equals("programmé") && lt.getPrevu_tuyaux().getApprovionnement_sur_chantier_et_bardage() != null && lt.getPrevu_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage() != null) {
                        datas.add(lt.getPrevu_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage());
                    }else if(ele.equals("programmé") && (lt.getPrevu_tuyaux().getApprovionnement_sur_chantier_et_bardage() == null || lt.getPrevu_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage() == null)){
                        datas.add(null);
                    }
                if(ele.equals("prévision")){
                    int counter = 0;
                    Double maxAppro = 0d;
                    System.out.println("prévision");
                        for (Tuyaux lt1 : this.tuyouxRepo.orderBydate()) {

                                if(lt1.getPrevu_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage()!= null){
                                    if(lt1.getPrevu_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage()>maxAppro){
                                        maxAppro = lt1.getPrevu_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage();
                                    }
                                }


                            if(lt1.getReel_tuyaux() == null){
                                counter = counter+1;
                            }

                            }

                    System.out.println(counter);
                    System.out.println(maxAppro);

                    if(lt.getReel_tuyaux()!= null){
                        if(lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage() !=null){
                            datas.add(lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage());
                            currentprevValue = lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage();
                            currentprevValue1 = lt.getReel_tuyaux().getQm_Approvionnement_sur_chantier_et_bardage();


                        }
                    }
                        else{
                        System.out.println("----------------------------");
                        System.out.println(currentprevValue);
                        System.out.println(counter);
                        System.out.println(maxAppro);
                        System.out.println("----------------------------");
                            currentprevValue =currentprevValue+((maxAppro-currentprevValue1)/(counter));
                            datas.add(currentprevValue);
                        }

                }
            }
            }
            tuyauxSerieItem.setData(datas);
            tuyauxes.add(tuyauxSerieItem);
        }



        return tuyauxes;
    }


    public List<Electrique> getElectrique(){
        return pelectriqueRepo.findAll();
    }

    public List<Actions> getActions(){
        return actionRepo.findAll();
    }

    public Tuyaux getTuyItemToEditByDate(Date date) {
        Tuyaux lt =  this.tuyouxRepo.getbyDate(date);
         return cumulation(lt);
    }


    public PompEvolution getPompItemToEdit() {
        System.out.println(this.getDayNumberOld(new Date()));

        if (this.getDayNumberOld(new Date()) < 4) {

            for (PompEvolution lt : this.pompEvoRepo.findAll()) {
                System.out.println(this.getweekOfYearVerifiaction(lt.getDate()));
                System.out.println(this.getDayNumberOld(lt.getDate()));
                System.out.println(this.getweekOfYearVerifiactionprev(lt.getDate()));
                System.out.println(this.getDayNumberOld(lt.getDate()));
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4) || (this.getweekOfYearVerifiactionprev(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4)) {

                    System.out.println("prev");
//todo

                    return cumulationPomp(lt);
                }
            }
        } else if (this.getDayNumberOld(new Date()) >= 4) {
            System.out.println("hana f tali");
            for (PompEvolution lt : this.pompEvoRepo.findAll()) {
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4) || (this.getweekOfYearVerifiactionnext(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4)) {
                    System.out.println("next");

                    return cumulationPomp(lt);

                }
            }
        }

        return PompEvolution.builder().reel_pomp(Reel_pomp.builder().build()).prevu_pomp(Prevu_pomp.builder().build()).build();

//       return  this.tuyouxRepo.findAll();
    }


    public MoteurEvolution getMoteurItemToEdit() {
        System.out.println(this.getDayNumberOld(new Date()));

        if (this.getDayNumberOld(new Date()) < 4) {

            for (MoteurEvolution lt : this.MoteurEvoRepo.findAll()) {
                System.out.println(this.getweekOfYearVerifiaction(lt.getDate()));
                System.out.println(this.getDayNumberOld(lt.getDate()));
                System.out.println(this.getweekOfYearVerifiactionprev(lt.getDate()));
                System.out.println(this.getDayNumberOld(lt.getDate()));
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4) || (this.getweekOfYearVerifiactionprev(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4)) {

                    System.out.println("prev");
//todo

                    return cumulationMoteur(lt);
                }
            }
        } else if (this.getDayNumberOld(new Date()) >= 4) {
            System.out.println("hana f tali");
            for (MoteurEvolution lt : this.MoteurEvoRepo.findAll()) {
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4) || (this.getweekOfYearVerifiactionnext(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4)) {
                    System.out.println("next");

                    return cumulationMoteur(lt);

                }
            }
        }

        return MoteurEvolution.builder().reel_moteur(Reel_moteur.builder().build()).prevu_moteur(Prevu_moteur.builder().build()).build();

//       return  this.tuyouxRepo.findAll();
    }
   public Electriquevolution getElectriqueItemToEdit() {


        if (this.getDayNumberOld(new Date()) < 4) {
            for (Electriquevolution lt : this.electriqueEvolutionRepo.findAll()) {
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4) || (this.getweekOfYearVerifiactionprev(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4)) {

                    System.out.println("prev");
//todo

                    return cumulationEle(lt);
                }
            }
        } else if (this.getDayNumberOld(new Date()) >= 4) {
            for (Electriquevolution lt : this.electriqueEvolutionRepo.findAll()) {
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4) || (this.getweekOfYearVerifiactionnext(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4)) {
                    System.out.println("next");

                    return cumulationEle(lt);

                }
            }
        }

        return Electriquevolution.builder().prevuPElectrique(PrevuPElectrique.builder().build()).reelPElectrique(ReelPElectrique.builder().build()).build();

//       return  this.tuyouxRepo.findAll();
    }

    public List<Notification_content> notification_content() {
    return  this.notification_content_repo.findAll();
    }

 public Notification_content saveNotification_content(Notification_content notification_content) {
    return  this.notification_content_repo.save(notification_content);
    }

    public Tuyaux getTuyItemToEdit() {



        if (this.getDayNumberOld(new Date()) < 4) {
            for (Tuyaux lt : this.tuyouxRepo.findAll()) {
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4) || (this.getweekOfYearVerifiactionprev(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4)) {

                    System.out.println("prev");


                    return cumulation(lt);
                }
            }
        } else if (this.getDayNumberOld(new Date()) >= 4) {
            for (Tuyaux lt : this.tuyouxRepo.findAll()) {
                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4) || (this.getweekOfYearVerifiactionnext(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4)) {
                    System.out.println("next");

                    return cumulation(lt);

                }
            }
        }

        return Tuyaux.builder().reel_tuyaux(Reel_tuyaux.builder().build()).prevu_tuyaux(Prevu_tuyaux.builder().build()).build();

//       return  this.tuyouxRepo.findAll();
    }

    public Terassement getTerrItemToEdit() {
return  this.terrassementRepo.getValidate();
//        if (this.getDayNumberOld(new Date()) < 4) {
//            for (Terassement lt : this.terrassementRepo.findAll()) {
//                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4) || (this.getweekOfYearVerifiactionprev(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4)) {
//
//                    System.out.println("prev");
//
//
//                    return lt;
//                }
//            }
//        } else if (this.getDayNumberOld(new Date()) >= 4) {
//            for (Terassement lt : this.terrassementRepo.findAll()) {
//                if ((this.getweekOfYearVerifiaction(lt.getDate()) && this.getDayNumberOld(lt.getDate()) >= 4) || (this.getweekOfYearVerifiactionnext(lt.getDate()) && this.getDayNumberOld(lt.getDate()) < 4)) {
//                    System.out.println("next");
//
//                    return lt;
//
//                }
//            }
//        }
//
//        return null;

//       return  this.tuyouxRepo.findAll();
    }
    public void doSomething() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // do something with the principal
    }


    public Principal user(Principal user) {
        return user;
    }

    public Tuyaux getTuyItemSynth() {
//todo
        Tuyaux current = this.getTuyItemToEdit();
        System.out.println("current"+current);
        if(this.tuyouxRepo.getValidate()== null){
            return Tuyaux.builder().date(new Date()).prevu_tuyaux(Prevu_tuyaux.builder().build()).reel_tuyaux(Reel_tuyaux.builder().build()).build();
        }
        Tuyaux validated = this.tuyouxRepo.getValidate();
        if(current.getDate() != null){
            validated.setPrevu_tuyaux(current.getPrevu_tuyaux());

        }
        return validated;

    }

    public Electriquevolution getElectriqueItemSynth() {

        Electriquevolution current = this.getElectriqueItemToEdit();
        Electriquevolution validated = this.electriqueEvolutionRepo.getValidate();
        if(validated == null){
            return Electriquevolution.builder().date(new Date()).prevuPElectrique(PrevuPElectrique.builder().build()).reelPElectrique(ReelPElectrique.builder().build()).build();
        }

        Electriquevolution electriquevolution = this.electriqueEvolutionRepo.findById(validated.getId()).get();
        System.out.println(electriquevolution.getReelPElectrique());
        System.out.println("ahmed sefriui");
        return electriquevolution;
    }



    public PompEvolution getPompEvolutioneItemSynth() {

        PompEvolution current = this.getPompItemToEdit();

        if(this.pompEvoRepo.getValidate()== null){
            return PompEvolution.builder().date(new Date()).prevu_pomp(Prevu_pomp.builder().build()).reel_pomp(Reel_pomp.builder().build()).build();
        }

        PompEvolution validated = this.pompEvoRepo.getValidate();
//        if(current.getDate() != null) {
//            validated.setPrevu_pomp(current.getPrevu_pomp());
//        }
        return  validated;

    }



    public MoteurEvolution getMoteurEvolutioneItemSynth() {

        MoteurEvolution current = this.getMoteurItemToEdit();

        if(this.MoteurEvoRepo.getValidate()== null){
            return MoteurEvolution.builder().date(new Date()).prevu_moteur(Prevu_moteur.builder().build()).reel_moteur(Reel_moteur.builder().build()).build();
        }

        MoteurEvolution validated = this.MoteurEvoRepo.getValidate();

//        if(current.getDate() != null) {
//            validated.setPrevu_moteur(current.getPrevu_moteur());
//        }
        return  validated;

    }





    private  Tuyaux     cumulation(Tuyaux lt){
        Double qm_depart_usine = 0D;
        Double qm_arrivee_port_Casa= 0D;
        Double qm_sortie_port_Casa= 0D;
        Double qm_Approvionnement_sur_chantier_et_bardage= 0D;
        Double qm_pose_Soudure_et_controle= 0D;

        for (Tuyaux lt1 : this.tuyouxRepo.findAll()) {
            if(lt1.getValidation1() != null && lt1.getValidation2()!=null){
                if(lt1.getDate().compareTo(lt.getDate()) < 0){

                    if(lt1.getReel_tuyaux().getQt_depart_usine() != null && lt1.getReel_tuyaux().getDepart_usine() !=null){
                        qm_depart_usine= qm_depart_usine+lt1.getReel_tuyaux().getQt_depart_usine();
                    }
                    if(lt1.getReel_tuyaux().getQt_arrivee_port_Casa()!= null && lt1.getReel_tuyaux().getArrivee_port_Casa() !=null){
                        qm_arrivee_port_Casa= qm_arrivee_port_Casa+lt1.getReel_tuyaux().getQt_arrivee_port_Casa();
                    }
                    if(lt1.getReel_tuyaux().getQt_sortie_port_Casa()!= null && lt1.getReel_tuyaux().getSortie_port_Casa() !=null){
                        qm_sortie_port_Casa= qm_sortie_port_Casa+lt1.getReel_tuyaux().getQt_sortie_port_Casa();
                    }
                    if(lt1.getReel_tuyaux().getQt_Approvionnement_sur_chantier_et_bardage()!= null && lt1.getReel_tuyaux().getApprovionnement_sur_chantier_et_bardage() !=null){
                        qm_Approvionnement_sur_chantier_et_bardage= qm_Approvionnement_sur_chantier_et_bardage+lt1.getReel_tuyaux().getQt_Approvionnement_sur_chantier_et_bardage();
                    }
                    if(lt1.getReel_tuyaux().getQt_pose_Soudure_et_controle()!= null && lt1.getReel_tuyaux().getPose_Soudure_et_controle() !=null){
                        qm_pose_Soudure_et_controle= qm_pose_Soudure_et_controle+lt1.getReel_tuyaux().getQt_pose_Soudure_et_controle();

                    }

                }

            }

            if(lt.getReel_tuyaux() ==null){
                Reel_tuyaux r =  Reel_tuyaux.builder().qm_arrivee_port_Casa(qm_arrivee_port_Casa).qm_sortie_port_Casa(qm_sortie_port_Casa).qm_Approvionnement_sur_chantier_et_bardage(qm_Approvionnement_sur_chantier_et_bardage).qm_depart_usine(qm_depart_usine).qm_pose_Soudure_et_controle(qm_pose_Soudure_et_controle).build();
                lt.setReel_tuyaux(r);
            }else{
                lt.getReel_tuyaux().setQm_Approvionnement_sur_chantier_et_bardage(qm_Approvionnement_sur_chantier_et_bardage);
                lt.getReel_tuyaux().setQm_arrivee_port_Casa(qm_arrivee_port_Casa);
                lt.getReel_tuyaux().setQm_sortie_port_Casa(qm_sortie_port_Casa);
                lt.getReel_tuyaux().setQm_depart_usine(qm_depart_usine);
                lt.getReel_tuyaux().setQm_pose_Soudure_et_controle(qm_pose_Soudure_et_controle);
            }
            }




        return lt;
    }


    private  PompEvolution cumulationPomp(PompEvolution lt){

        Double qmAvacementPhysique = 0D;
        Double qmAvacementtemp = 0D;
        Double avacementtemp = 0D;
        Double avacementPhysique = 0D;

        for (PompEvolution lt1 : this.pompEvoRepo.findAll()) {
            if(lt1.getValidation1() != null && lt1.getValidation2()!=null){
                if(lt1.getDate().compareTo(lt.getDate()) < 0){

                    if(lt1.getReel_pomp().getAvacementtemp() != null){
                        qmAvacementtemp= qmAvacementtemp+lt1.getReel_pomp().getAvacementtemp() ;
                    }

                    if(lt1.getReel_pomp().getAvacementPhysique() != null){
                        qmAvacementPhysique= qmAvacementPhysique+lt1.getReel_pomp().getAvacementPhysique() ;
                    }

                }

            }

            if(lt.getReel_pomp() ==null){
                Reel_pomp r =  Reel_pomp.builder().qmAvacementPhysique(qmAvacementPhysique).qmAvacementtemp(qmAvacementtemp).avacementtemp(avacementtemp).avacementPhysique(avacementPhysique).build();
                lt.setReel_pomp(r);
            }else{
                lt.getReel_pomp().setQmAvacementtemp(qmAvacementtemp);
                lt.getReel_pomp().setQmAvacementPhysique(qmAvacementPhysique);

            }
        }




        return lt;
    }

    private  MoteurEvolution cumulationMoteur(MoteurEvolution lt){

        Double qmAvacementPhysique = 0D;
        Double qmAvacementtemp = 0D;
        Double avacementtemp = 0D;
        Double avacementPhysique = 0D;

        for (MoteurEvolution lt1 : this.MoteurEvoRepo.findAll()) {
            if(lt1.getValidation1() != null && lt1.getValidation2()!=null){
                if(lt1.getDate().compareTo(lt.getDate()) < 0){

                    if(lt1.getReel_moteur().getAvacementtemp() != null){
                        qmAvacementtemp= qmAvacementtemp+lt1.getReel_moteur().getAvacementtemp() ;
                    }

                    if(lt1.getReel_moteur().getAvacementPhysique() != null){
                        qmAvacementPhysique= qmAvacementPhysique+lt1.getReel_moteur().getAvacementPhysique() ;
                    }

                }

            }

            if(lt.getReel_moteur() ==null){
                Reel_moteur r =  Reel_moteur.builder().qmAvacementPhysique(qmAvacementPhysique).qmAvacementtemp(qmAvacementtemp).avacementtemp(avacementtemp).avacementPhysique(avacementPhysique).build();
                lt.setReel_moteur(r);
            }else{
                lt.getReel_moteur().setQmAvacementtemp(qmAvacementtemp);
                lt.getReel_moteur().setQmAvacementPhysique(qmAvacementPhysique);

            }
        }




        return lt;
    }
 private  Electriquevolution cumulationEle(Electriquevolution lt){

        Double qmAvacementPhysique = 0D;
        Double qmAvacementtemp = 0D;
        Double avacementtemp = 0D;
        Double avacementPhysique = 0D;

        for (Electriquevolution lt1 : this.electriqueEvolutionRepo.findAll()) {
            if(lt1.getValidation1() != null && lt1.getValidation2()!=null){
                if(lt1.getDate().compareTo(lt.getDate()) < 0){

                    if(lt1.getReelPElectrique().getAvacementtemp() != null){
                        qmAvacementtemp= qmAvacementtemp+lt1.getReelPElectrique().getAvacementtemp() ;
                    }

                    if(lt1.getReelPElectrique().getAvacementPhysique() != null){
                        qmAvacementPhysique= qmAvacementPhysique+lt1.getReelPElectrique().getAvacementPhysique() ;
                    }

                }

            }

            if(lt.getReelPElectrique() ==null){
                System.out.println("maandouch");
                ReelPElectrique r =  ReelPElectrique.builder().qmAvacementPhysique(qmAvacementPhysique).qmAvacementtemp(qmAvacementtemp).avacementtemp(avacementtemp).avacementPhysique(avacementPhysique).build();
                lt.setReelPElectrique(r);
            }else{
                System.out.println("aandou");

                lt.getReelPElectrique().setQmAvacementtemp(qmAvacementtemp);
                lt.getReelPElectrique().setQmAvacementPhysique(qmAvacementPhysique);

            }
        }


     System.out.println(lt);
        return lt;
    }



    public Profil saveProfil(Profil profil){
        return this.profilRepository.save(profil);
    }
    public List<Profil> getprofiles(){
       return this.profilRepository.findAll();

    }

    @PostMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody MyUser myUser){

        return new ResponseEntity<>(this.userService.saveUser(myUser), HttpStatus.OK);
    }


    public  boolean getweekOfYearVerifiaction(Date date1) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int week = cal.get(Calendar.WEEK_OF_YEAR);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date1);
        cal2.setFirstDayOfWeek(Calendar.MONDAY);
        int week2 = cal2.get(Calendar.WEEK_OF_YEAR);

        return week == week2;

    }


    public static boolean getweekOfYearVerifiactionnext(Date date1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int week = cal.get(Calendar.WEEK_OF_YEAR);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date1);
        cal2.setFirstDayOfWeek(Calendar.MONDAY);
        int week2 = cal2.get(Calendar.WEEK_OF_YEAR);




        return (week+1) == week2;

    }


    public static boolean getweekOfYearVerifiactionprev(Date date1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int week = cal.get(Calendar.WEEK_OF_YEAR);

//todo
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date1);
        cal2.setFirstDayOfWeek(Calendar.MONDAY);
        int week2 = cal2.get(Calendar.WEEK_OF_YEAR);

        if(week == 1 ){
            return 52 == week2;
        }
        return (week-1) == week2;
    }



    public  int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_WEEK);
    }


    public void send_mail(String header){
        for(MyUser ele : userRepo.findAll()){
            if(ele.getProfil() != null) {
                for(Habilitation ha : ele.getProfil().getHabilitations()){
                    if(ha.getName().equals("insert")){
                        if(ele.getEmail() != null){
                            String data = "<h6>" + header + "<h6>"+
                                    "<p style='font-size:12px;color:grey'> " + "utilisateur:"+(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()+ "a bien validé les données a "+ getformatedDate(new Date())+"</p>";


                            String data2 = "utilisateur:"+(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()+
                                    "a bien validé les données a "+ getformatedDate(new Date());



                            if(ele.getNotifications() != null){
                                System.out.println(ele.getNotifications());
                                ele.getNotifications().add(Notification.builder().intitule(header).content(data2).type("warning").sended_by("system").sended_at(new Date()).read(false).build());

                            }else {
                                List<Notification> notificationList = new ArrayList<>();
                                notificationList.add(Notification.builder().intitule(header).content(data2).type("warning").sended_by("system").sended_at(new Date()).read(false).build());
                                ele.setNotifications(notificationList);
                            }
                            userRepo.save(ele);


                            EmailDetails emailDetails = EmailDetails.builder().subject(header)
                                    .msgBody(data).recipient(ele.getEmail()).build();

                            String status = emailService.sendHtmlSimpleMail(emailDetails);
                            System.out.println(status);



                        }}}}}

    }




}
