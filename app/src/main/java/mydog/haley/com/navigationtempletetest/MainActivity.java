package mydog.haley.com.navigationtempletetest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Toolbar : Toolbar를 커스텀 해서 화면 상단에 위치한 ActionBar를 대체 할 수 있음
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        // setSupportActionBar : ActionBar를 생성한 Toolbar로 대체
        setSupportActionBar(toolbar);

        // 2. FloatingActionButton : circle 모양의 버튼, default 사이즈 & mini 사이즈 있음
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar : 스크린 아래에서 짧은 메세지 보여주고 사라짐
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 3. DrawerLayout :  top-level container,
        // 자식뷰의 layout_gravity 속성으로 세로의 어느 쪽에서 뷰를 끌어올 것인지 설정 가능 - letf/right(또는 start/end)
        // 세로 끝에서 뷰를 끌어오는데 한 끝쪽에서 한 개의 drawer view만 가져올 수 있음
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);

        // 4. ActionBarDrawerToggle : 네비게이션 Drawer의 상태를 알려주는 내용 표시(글 또는 아이콘) ?? 아직 잘 모르겠다
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // addDrawerListener : API 23 부터는 setDraweListener -> addDrawerListener으로 변경
        drawer.addDrawerListener(toggle);
        // syncState : 링크된 드로어레이아웃과 & Drawer indicator/affordance의 상태를 동기화 시킴
        toggle.syncState();

        // 5. NavigationView : 네비게이션 메뉴, 주로 DrawerLayout 안에 위치함
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        // setNavigationItemSelectedListener: 네비게이션 메뉴 켜지면 onNavigationItemSelected() 함수 호출
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        // 1. isDrawerOpen(Drawer 지정) : 현재 START/END 또는 RIGHT/LEFT gravity에 있는 Drawer가 오픈 상태인지 체크
        // GravityCompat.START : gravity가 START인 Drawer 지정
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            // 만약 해당 Drawer가 오픈 상태이면, 오픈 상태의 Drawer를 닫아주세요
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // Drawer가 오픈 상태가 아닌 경우 super예약어를 통해 상위 클래스의 onBackPressed() 함수 실행
            // -> 즉, 어플리케이션 종료
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // onNavigationItemSelected : 네이게이션 메뉴의 아이템 선택 시 실행할 함수 구현
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_camera) {
            // Handle the camera action
        } else if(id == R.id.nav_gallery) {

        } else if(id == R.id.nav_slideshow) {

        } else if(id == R.id.nav_manage) {

        } else if(id == R.id.nav_share) {

        } else if(id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
