package the_debuggers.com.easybilkent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_run);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mMap = mapFragment.getMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        Intent intent = getIntent();
        String selected_building = null;
        if (intent != null)
            selected_building = intent.getStringExtra("building");
        else
            selected_building = "DEFAULT";
        Log.e("Progress", "Picked up Location " + selected_building );

        // Add a marker for the central view and move the camera
        LatLng bilkent_central_view = new LatLng(39.868916, 32.746797);
        mMap.addMarker(new MarkerOptions().position(bilkent_central_view).title("Bilkent University"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bilkent_central_view, 15), null);

        // *************  Dorms 50 - 52  **************
        // Add a marker in Dorm 50  and move the camera
        LatLng dorm_50 = new LatLng(39.865029, 32.749220);
        mMap.addMarker(new MarkerOptions().position(dorm_50).title("Dorm 50"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_50));

        // Add a marker in Dorm 51  and move the camera
        LatLng dorm_51 = new LatLng(39.865164, 32.749421);
        mMap.addMarker(new MarkerOptions().position(dorm_51).title("Dorm 51"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_51));

        // Add a marker in Dorm 52  and move the camera
        LatLng dorm_52 = new LatLng(39.864879, 32.749792);
        mMap.addMarker(new MarkerOptions().position(dorm_52).title("Dorm 52"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_52));

        // *************  Dorms 54 - 55  **************
        // Add a marker in Dorm 54 and move the camera
        LatLng dorm_54 = new LatLng(39.864561, 32.749757);
        mMap.addMarker(new MarkerOptions().position(dorm_54).title("Dorm 54"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_54));

        // Add a marker in Dorm 55 and move the camera
        LatLng dorm_55 = new LatLng(39.864399, 32.749952);
        mMap.addMarker(new MarkerOptions().position(dorm_55).title("Dorm 55"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_55));

        // *************  Dorms 60 - 64  **************
        // Add a marker in Dorm 60 and move the camera
        LatLng dorm_60 = new LatLng(39.864026, 32.749718);
        mMap.addMarker(new MarkerOptions().position(dorm_60).title("Dorm 60"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_60));

        // Add a marker in Dorm 61 and move the camera
        LatLng dorm_61 = new LatLng(39.863860, 32.749551);
        mMap.addMarker(new MarkerOptions().position(dorm_61).title("Dorm 61"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_61));

        // Add a marker in Dorm 62 and move the camera
        LatLng dorm_62 = new LatLng(39.863689, 32.749726);
        mMap.addMarker(new MarkerOptions().position(dorm_62).title("Dorm 62"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_62));

        // Add a marker in Dorm 63 and move the camera
        LatLng dorm_63 = new LatLng(39.863555, 32.749553);
        mMap.addMarker(new MarkerOptions().position(dorm_63).title("Dorm 63"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_63));

        // Add a marker in Dorm 64 and move the camera
        LatLng dorm_64 = new LatLng(39.863465, 32.749084);
        mMap.addMarker(new MarkerOptions().position(dorm_64).title("Dorm 64"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_64));

        // *************  Dorms  69 - 78  **************
        // Add a marker in Dorm 69  and move the camera
        LatLng dorm_69 = new LatLng(39.864598, 32.749070);
        mMap.addMarker(new MarkerOptions().position(dorm_69).title("Dorm 69"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_69));

        // Add a marker in Dorm 70  and move the camera
        LatLng dorm_70 = new LatLng(39.864093, 32.749182);
        mMap.addMarker(new MarkerOptions().position(dorm_70).title("Dorm 70"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_70));

        // Add a marker in Dorm 71 and move the camera
        LatLng dorm_71 = new LatLng(39.864297, 32.748608);
        mMap.addMarker(new MarkerOptions().position(dorm_71).title("Dorm 71"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_71));

        // Add a marker in Dorm 72 and move the camera
        LatLng dorm_72 = new LatLng(39.864088, 32.748560);
        mMap.addMarker(new MarkerOptions().position(dorm_72).title("Dorm 72"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_72));

        // Add a marker in Dorm 73 and move the camera
        LatLng dorm_73 = new LatLng(39.863876, 32.748519);
        mMap.addMarker(new MarkerOptions().position(dorm_73).title("Dorm 73"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_73));

        // Add a marker in Dorm 74 and move the camera
        LatLng dorm_74 = new LatLng(39.863688, 32.748448);
        mMap.addMarker(new MarkerOptions().position(dorm_74).title("Dorm 74"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_74));

        // Add a marker in Dorm 75 and move the camera
        LatLng dorm_75 = new LatLng(39.864037, 32.747678);
        mMap.addMarker(new MarkerOptions().position(dorm_75).title("Dorm 75"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_75));

        // Add a marker in Dorm 76 and move the camera
        LatLng dorm_76 = new LatLng(39.864503, 32.747665);
        mMap.addMarker(new MarkerOptions().position(dorm_76).title("Dorm 76"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_76));
        // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_76, 18), null);

        // Add a marker in Dorm 77 and move the camera
        LatLng dorm_77 = new LatLng(39.864484, 32.746575);
        mMap.addMarker(new MarkerOptions().position(dorm_77).title("Dorm 77"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_77));

        // Add a marker in Dorm 78 and move the camera
        LatLng dorm_78 = new LatLng(39.865159, 32.746091);
        mMap.addMarker(new MarkerOptions().position(dorm_78).title("Dorm 78"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_78));

        // Add a marker in 79th faculty house and move the camera
        LatLng j_79_faculty_house = new LatLng(39.865281, 32.744962);
        mMap.addMarker(new MarkerOptions().position(j_79_faculty_house).title("79 Faculty House"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(j_79_faculty_house));

        // Add a marker in 80th faculty house and move the camera
        LatLng j_80_faculty_house = new LatLng(39.864886, 32.744944);
        mMap.addMarker(new MarkerOptions().position(j_80_faculty_house).title(" "));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(j_80_faculty_house));

        // Add a marker in Bilkent Stadium and move the camera
        LatLng bilkent_stadium = new LatLng(39.864336, 32.743383);
        mMap.addMarker(new MarkerOptions().position(bilkent_stadium).title("Bilkent Stadium"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bilkent_stadium));

        // Add a marker in Office of Int.Students and Exchange Prog. and move the camera
        LatLng int_office = new LatLng(39.864211, 32.744948);
        mMap.addMarker(new MarkerOptions().position(int_office).title("Office of Int.Students & Exchange "));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(int_office));

        // Add a marker in Registrar's office and move the camera
        LatLng registrars_office = new LatLng(39.864290, 32.744955);
        mMap.addMarker(new MarkerOptions().position(registrars_office).title("Registrar's office"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(registrars_office));

        // Add a marker in Security & Civil Defense Office and move the camera
        LatLng security_and_civil_defense_office = new LatLng(39.864311, 32.744575);
        mMap.addMarker(new MarkerOptions().position(security_and_civil_defense_office).title("Security & Civil Defense Office"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng( security_and_civil_defense_office));

        // Add a marker in Dormitories Management and move the camera
        LatLng dormitories_management = new LatLng(39.863518, 32.749009);
        mMap.addMarker(new MarkerOptions().position(dormitories_management).title("Dormitories Management"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dormitories_management));

        // Add a marker in PTT and move the camera
        LatLng ptt = new LatLng(39.864435, 32.744538);
        mMap.addMarker(new MarkerOptions().position(ptt).title("PTT"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(ptt));

        // Add a marker in the Sports Center and move the camera
        LatLng sports_center = new LatLng(39.863578, 32.745607);
        mMap.addMarker(new MarkerOptions().position(sports_center).title("Sports Center"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sports_center));

        // Add a marker in Dorm Cafeteria and move the camera
        LatLng dorm_cafeteria = new LatLng(39.863427, 32.747406);
        mMap.addMarker(new MarkerOptions().position(dorm_cafeteria).title("Dorm Cafeteria"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_cafeteria));

        // Add a marker in Dorm Sports Field 1  and move the camera
        LatLng dorm_sports_field1 = new LatLng(39.863653, 32.747426);
        mMap.addMarker(new MarkerOptions().position(dorm_sports_field1).title("Dorm Sports Field 1"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(dorm_sports_field1));

        // Add a marker in Sports Field 2 and move the camera
        LatLng dorm_sports_field2 = new LatLng(39.863466, 32.746775);
        mMap.addMarker(new MarkerOptions().position(dorm_sports_field2).title("Sports Field 2"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sports_field2));

        // Add a marker in Bus Stop Dorm 76 and move the camera
        LatLng bus_stop_76 = new LatLng(39.865185, 32.748275);
        mMap.addMarker(new MarkerOptions().position(bus_stop_76).title("Bus Stop Dorm 76"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bus_stop_76));

        // Add a marker in FF Building  and move the camera
        LatLng ff_building = new LatLng(39.865829, 32.748928);
        mMap.addMarker(new MarkerOptions().position(ff_building).title("FF Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(ff_building));

        // Add a marker in Express Cafe  and move the camera
        LatLng express_cafe = new LatLng(39.866235, 32.749301);
        mMap.addMarker(new MarkerOptions().position(express_cafe).title("Express Cafe"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(express_cafe));

        // Add a marker in FA Building  and move the camera
        LatLng fa_building = new LatLng(39.866234, 32.750031);
        mMap.addMarker(new MarkerOptions().position(fa_building).title("FA Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(fa_building));

        // Add a marker in FB Building and move the camera
        LatLng fb_building = new LatLng(39.866540, 32.750092);
        mMap.addMarker(new MarkerOptions().position(fb_building).title("FB Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(fb_building));

        // Add a marker in FC Building and move the camera
        LatLng fc_building = new LatLng(39.867016, 32.749518);
        mMap.addMarker(new MarkerOptions().position(fc_building).title("FC Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(fc_building));

        // Add a marker in FD Building  and move the camera
        LatLng fd_building = new LatLng(39.866452, 32.749211);
        mMap.addMarker(new MarkerOptions().position(fd_building).title("FD Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(fd_building));

        // Add a marker in A Building and move the camera
        LatLng a_building = new LatLng(39.867675, 32.749433);
        mMap.addMarker(new MarkerOptions().position(a_building).title("A Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(a_building));

        // Add a marker in T Building and move the camera
        LatLng t_building = new LatLng(39.868299, 32.749225);
        mMap.addMarker(new MarkerOptions().position(t_building).title("T Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(t_building));

        // Add a marker in H Building and move the camera
        LatLng h_building = new LatLng(39.868070, 32.749981);
        mMap.addMarker(new MarkerOptions().position(h_building).title("H Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(h_building));

        // Add a marker in V Building and move the camera
        LatLng v_building = new LatLng(39.867082, 32.750195);
        mMap.addMarker(new MarkerOptions().position(v_building).title("V Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(v_building));

        // Add a marker in Cafe Alis and move the camera
        LatLng cafe_alis = new LatLng(39.866978, 32.750196);
        mMap.addMarker(new MarkerOptions().position(cafe_alis).title("Cafe Alis"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(cafe_alis));

        // Add a marker in M Building and move the camera
        LatLng m_building = new LatLng(39.867351, 32.750192);
        mMap.addMarker(new MarkerOptions().position(m_building).title("M Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(m_building));

        // Add a marker in Starbucks Coffee and move the camera
        LatLng starbucks_coffee = new LatLng(39.867495, 32.750257);
        mMap.addMarker(new MarkerOptions().position(starbucks_coffee).title("Starbucks Coffee"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(starbucks_coffee));

        // Add a marker in Mescit and move the camera
        LatLng mescit = new LatLng(39.867387, 32.750736);
        mMap.addMarker(new MarkerOptions().position(mescit).title("Mescit"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(mescit));

        // Add a marker in G Building and move the camera
        LatLng g_building = new LatLng(39.868685, 32.749882);
        mMap.addMarker(new MarkerOptions().position(g_building).title("G Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(g_building));

        // Add a marker in Pharmacy and move the camera
        LatLng pharmacy = new LatLng(39.868131, 32.749208);
        mMap.addMarker(new MarkerOptions().position(pharmacy).title("Pharmacy"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(pharmacy));

        // Add a marker in Coffee Break and move the camera
        LatLng coffee_break_t = new LatLng(39.868219, 32.749039);
        mMap.addMarker(new MarkerOptions().position(coffee_break_t).title("Coffee Break T"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee_break_t));

        // Add a marker in Health Center and move the camera
        LatLng health_center = new LatLng(39.868356, 32.749111);
        mMap.addMarker(new MarkerOptions().position(health_center).title("Health Center"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(health_center));

        // Add a marker in LA Building and move the camera
        LatLng la_building = new LatLng(39.869282, 32.749672);
        mMap.addMarker(new MarkerOptions().position(la_building).title("LA Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(la_building));

        // Add a marker in LB Building and move the camera
        LatLng lb_building = new LatLng(39.869309, 32.749944);
        mMap.addMarker(new MarkerOptions().position(lb_building).title("LB Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(lb_building));

        // Add a marker in LC Building and move the camera
        LatLng lc_building = new LatLng(39.869296, 32.750217);
        mMap.addMarker(new MarkerOptions().position(lc_building).title("LC Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(lc_building));

        // Add a marker in Ihsan Dogramaci Square and move the camera
        LatLng ihsan_d_square = new LatLng(39.868905, 32.748753);
        mMap.addMarker(new MarkerOptions().position(ihsan_d_square).title("Ihsan Dogramaci Square"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(i_d_square));

        // Add a marker in Main Campus Library and move the camera
        LatLng main_library = new LatLng(39.870314, 32.749533);
        mMap.addMarker(new MarkerOptions().position(main_library).title("Main Campus Library"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(main_library));

        // Add a marker in Int.Children Center and move the camera
        LatLng int_children_center = new LatLng(39.870104, 32.749793);
        mMap.addMarker(new MarkerOptions().position(int_children_center).title("Int.Children Center"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(int_children_center));

        // Add a marker in Coffee Break and move the camera
        LatLng coffee_break_l = new LatLng(39.869507, 32.749958);
        mMap.addMarker(new MarkerOptions().position(coffee_break_l).title("Coffee Break L"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee_break_l));

        // Add a marker in Coffee Break and move the camera
        LatLng coffee_break_library = new LatLng(39.870201, 32.749452);
        mMap.addMarker(new MarkerOptions().position(coffee_break_library).title("Coffee Break Library"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(coffee_break_library));

        // Add a marker in Marmara and move the camera
        LatLng marmara = new LatLng(39.870288, 32.750534);
        mMap.addMarker(new MarkerOptions().position(marmara).title("Marmara"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(marmara));

        // Add a marker in Cafe In and move the camera
        LatLng cafe_in = new LatLng(39.869928, 32.750531);
        mMap.addMarker(new MarkerOptions().position(cafe_in).title("Cafe In"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(cafe_in));

        // Add a marker in International Center and move the camera
        LatLng int_center = new LatLng(39.871143, 32.749949);
        mMap.addMarker(new MarkerOptions().position(int_center).title("International Center"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(int_center));

        // Add a marker in Rector's Office and move the camera
        LatLng rector_office = new LatLng(39.871258, 32.750056);
        mMap.addMarker(new MarkerOptions().position(rector_office).title("Rector's Office "));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(rector_office));

        // Add a marker in EA Building and move the camera
        LatLng ea_building = new LatLng(39.871207, 32.749935);
        mMap.addMarker(new MarkerOptions().position(ea_building).title("EA Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(ea_building));

        // Add a marker in Yapi Kredi Bank and move the camera
        LatLng yapi_bank = new LatLng(39.871427, 32.750162);
        mMap.addMarker(new MarkerOptions().position(yapi_bank).title("Yapi Kredi Bank"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(yapi_bank));

        // Add a marker in EB Building and move the camera
        LatLng eb_building = new LatLng(39.871750, 32.749823);
        mMap.addMarker(new MarkerOptions().position(eb_building).title("EB Building "));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(eb_building));

        // Add a marker in EE Building and move the camera
        LatLng ee_building = new LatLng(39.872102, 32.750718);
        mMap.addMarker(new MarkerOptions().position(ee_building).title("EE Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(ee_building));

        // Add a marker in Mozart Caffee EE  and move the camera
        LatLng mozart_caffee_ee = new LatLng(39.872106, 32.750926);
        mMap.addMarker(new MarkerOptions().position(mozart_caffee_ee).title("Mozart Caffee EE"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(mozart_caffee_ee));

        // Add a marker in Meteksan Market and move the camera
        LatLng meteksan_market = new LatLng(39.872446, 32.751279);
        mMap.addMarker(new MarkerOptions().position(meteksan_market).title("Meteksan Market"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(meteksan_market));

        // Add a marker in Career Center and move the camera
        LatLng career_center = new LatLng(39.872625, 32.750365);
        mMap.addMarker(new MarkerOptions().position(career_center).title("Career Center"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(career_center));

        // Add a marker in U Building and move the camera
        LatLng u_building = new LatLng(39.872666, 32.750356);
        mMap.addMarker(new MarkerOptions().position(u_building).title("U Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(u_building));

        // Add a marker in Bus Stop Rektorluk and move the camera
        LatLng bus_stop_rektorluk = new LatLng(39.871685, 32.749078);
        mMap.addMarker(new MarkerOptions().position(bus_stop_rektorluk).title("Bus Stop Rektorluk"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bus_stop_rektorluk));

        // Add a marker in Bus Stop Nizamiye and move the camera
        LatLng bus_stop_nizamiye = new LatLng(39.869499, 32.748222);
        mMap.addMarker(new MarkerOptions().position(bus_stop_nizamiye).title("Bus Stop Nizameye"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(bus_stop_nizamiye));

        // Add a marker in B Building and move the camera
        LatLng b_building = new LatLng(39.868792, 32.748027);
        mMap.addMarker(new MarkerOptions().position(b_building).title("B Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(b_building));

        // Add a marker in SB Building and move the camera
        LatLng sb_building = new LatLng(39.868242, 32.748166);
        mMap.addMarker(new MarkerOptions().position(sb_building).title("SB Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sb_building));

        // Add a marker in SA Building and move the camera
        LatLng sa_building = new LatLng(39.867665, 32.748329);
        mMap.addMarker(new MarkerOptions().position(sa_building).title("SA Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sa_building));

        // Add a marker in SL Building and move the camera
        LatLng sl_building = new LatLng(39.867218, 32.748406);
        mMap.addMarker(new MarkerOptions().position(sl_building).title("SL Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sl_building));

        // Add a marker in SN Building  and move the camera
        LatLng sn_building = new LatLng(39.867493, 32.748199);
        mMap.addMarker(new MarkerOptions().position(sn_building).title("SN Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sn_building));

        // Add a marker in SM Building  and move the camera
        LatLng sm_building = new LatLng(39.867608, 32.747108);
        mMap.addMarker(new MarkerOptions().position(sm_building).title("SM Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sm_building));

        // Add a marker in ST Building and move the camera
        LatLng st_building = new LatLng(39.868115, 32.747062);
        mMap.addMarker(new MarkerOptions().position(st_building).title("ST Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(st_building));

        // Add a marker in SU Building and move the camera
        LatLng su_building = new LatLng(39.867815, 32.747791);
        mMap.addMarker(new MarkerOptions().position(su_building).title("SU Building"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(su_building));

        // Add a marker in Sports Center F and move the camera
        LatLng sports_center_f = new LatLng(39.866654, 32.748434);
        mMap.addMarker(new MarkerOptions().position(sports_center_f).title("Sports Center F"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sports_center_f));

        // Add a marker in Meteksan Bookstore and move the camera
        LatLng meteksan_bookstore = new LatLng(39.866268, 32.748442);
        mMap.addMarker(new MarkerOptions().position(meteksan_bookstore).title("Meteksan Bookstore"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(meteksan_bookstore));

        // Add a marker in Speed Restaurant and move the camera
        LatLng speed_restaurant = new LatLng(39.866027, 32.748407);
        mMap.addMarker(new MarkerOptions().position(speed_restaurant).title("Speed Restaurant"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(speed_restaurant));

        switch (selected_building)
        {
            case("79 Faculty House"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(j_79_faculty_house, 18), 2000,null);
                break;

            case("80 Faculty House "):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(j_80_faculty_house, 18), 2000,null);
                break;

            case("A Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(a_building, 18), 2000,null);
                break;

            case("B Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(b_building, 18), 2000,null);
                break;

            case("Bilkent Stadium"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bilkent_stadium, 18), 2000,null);
                break;

            case("Bus Stop Dorm 76"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bus_stop_76, 18), 2000,null);
                break;

            case("Bus Stop Nizameye"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bus_stop_nizamiye, 18), 2000,null);
                break;

            case("Bus Stop Rektorluk"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bus_stop_rektorluk, 18), 2000,null);
                break;

            case("Cafe Alis "):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cafe_alis, 18), 2000,null);
                break;

            case("Cafe In"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cafe_in, 18), 2000,null);
                break;

            case("Career Center"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(career_center, 18), 2000,null);
                break;

            case("Coffee Break L"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coffee_break_l, 18), 2000,null);
                break;

            case("Coffee Break Library"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coffee_break_library, 18), 2000,null);
                break;

            case("Coffee Break T"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coffee_break_t, 18), 2000,null);
                break;

            case("Dorm 50"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_50, 18), 2000,null);
                break;
            case("Dorm 51"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_51, 18), 2000,null);
                break;

            case("Dorm 52"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_52, 18), 2000,null);
                break;

            case("Dorm 54"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_54, 18), 2000,null);
                break;

            case("Dorm 55"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_55, 18), 2000,null);
                break;

            case("Dorm 60"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_60, 18), 2000,null);
                break;

            case("Dorm 61"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_61, 18), 2000,null);
                break;

            case("Dorm 62"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_62, 18), 2000,null);
                break;

            case("Dorm 63"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_63, 18), 2000,null);
                break;

            case("Dorm 64"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_64, 18), 2000,null);
                break;

            case("Dorm 69"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_69, 18), 2000,null);
                break;

            case("Dorm 70"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_70, 18), 2000,null);
                break;

            case("Dorm 71"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_71, 18), 2000,null);
                break;

            case("Dorm 72"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_72, 18), 2000,null);
                break;

            case("Dorm 73"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_73, 18), 2000,null);
                break;

            case("Dorm 74"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_74, 18), 2000,null);
                break;

            case("Dorm 75"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_75, 18), 2000,null);
                break;

            case("Dorm 76"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_76, 18), 2000,null);
                break;

            case("Dorm 77"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_77, 18), 2000,null);
                break;

            case("Dorm 78"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_78, 18), 2000,null);
                break;

            case("Dorm Cafeteria"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_cafeteria, 18), 2000,null);
                break;

            case("Dorm Sports Center"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sports_center, 18), 2000,null);
                break;

            case("Dorm Sports Field 1"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_sports_field1, 18), 2000,null);
                break;

            case("Dorm Sports Field 2"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dorm_sports_field2, 18), 2000,null);
                break;

            case("Dormitories Management"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dormitories_management, 18), 2000,null);
                break;

            case("EA Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ea_building, 18), 2000,null);
                break;

            case("EB Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(eb_building, 18), 2000,null);
                break;

            case("EE Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ee_building, 18), 2000,null);
                break;

            case("Express Cafe"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(express_cafe, 18), 2000,null);
                break;

            case("FA Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fa_building, 18), 2000,null);
                break;

            case("FB Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fb_building, 18), 2000,null);
                break;

            case("FC Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fc_building, 18), 2000,null);
                break;

            case("FF Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ff_building, 18), 2000,null);
                break;

            case("G Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(g_building, 18), 2000,null);
                break;

            case("H Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(h_building, 18), 2000,null);
                break;

            case("Ihsan Dogramaci Square"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ihsan_d_square, 18), 2000,null);
                break;

            case("International Center"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(int_center, 18), 2000,null);
                break;

            case("LA Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(la_building, 18), 2000,null);
                break;

            case("LB Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lb_building, 18), 2000,null);
                break;

            case("LC Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lc_building, 18), 2000,null);
                break;

            case("M Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(m_building, 18), 2000,null);
                break;

            case("Main Campus Library"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(main_library, 18), 2000,null);
                break;

            case("Marmara"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marmara, 18), 2000,null);
                break;

            case("Mescit"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mescit, 18), 2000,null);
                break;

            case("Meteksan Bookstore"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(meteksan_bookstore, 18), 2000,null);
                break;

            case("Meteksan Market"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(meteksan_market, 18), 2000,null);
                break;

            case("PTT"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ptt, 18), 2000,null);
                break;

            case("Pharmacy"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pharmacy, 18), 2000,null);
                break;

            case("Rector's Office"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(rector_office, 18), 2000,null);
                break;

            case("Registrar's Office"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(registrars_office, 18), 2000,null);
                break;

            case("SA Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sa_building, 18), 2000,null);
                break;

            case("SB Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sb_building, 18), 2000,null);
                break;

            case("SL Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sl_building, 18), 2000,null);
                break;

            case("SM Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sm_building, 18), 2000,null);
                break;

            case("SN Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sn_building, 18), 2000,null);
                break;

            case("ST Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(st_building, 18), 2000,null);
                break;

            case("SU Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(su_building, 18), 2000,null);
                break;

            case("Speed Restaurant"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(speed_restaurant, 18), 2000,null);
                break;

            case("Sports Center F"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sports_center_f, 18), 2000,null);
                break;

            case("Starbucks Coffee"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(starbucks_coffee, 18), 2000,null);
                break;

            case("T Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(t_building, 18), 2000,null);
                break;

            case("U Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(u_building, 18), 2000,null);
                break;

            case("V Building"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(v_building, 18), 2000,null);
                break;

            case("Yapi Kredi Bank"):
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(yapi_bank, 18), 2000,null);
                break;
        }
        // more markers to be added
        /*
         Add a marker in  and move the camera
        LatLng name = new LatLng();
        mMap.addMarker(new MarkerOptions().position(name).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(name));
        */
    }
}
