<h2>Rakenduse käivitamine</h2>
<p>Käivita cgi_proovitoo/dockercompose.yml file, et alustada andmebaas</p>
<p>Käivita Spring Boot Application CgiProovtooApplication, mille leiab src/main/java/org/example/cgi_proovitoo/CgiProovitooApplication.java</p>
<p>Käivita vue.js minnes terminalis frontend kausta (cd front_end) ning kasuta käsklust "npm install", "npm run build" ja "npm run dev"</p>
<p>Veebilehekülg avaneb http://localhost:5173/</p>

<h2>Rakenduse tööpõhimõte</h2>
<p>Rakenduse backend koosneb põhimõtteliselt neljast osast. </p>
<p>Conrolleris leiab endpoindid ja endpointidega saadetud DTOd.</p>
<p>Repositoryst leiab entitied ja repositoryd, mille kaudu suhtlvad endpoindid andmebaasiga.</p>
<p>Services leiab nii-öelda äriloogika ja selle alla kuuluvad meetodid.</p>
<p>Vue.js aitab visualiseerida andmeid ja liikumise endpointide vahel.</p>

<h2>Ülesande lahenduse kirjeldus</h2>
<p>Sessioone saab filtreerida sisestades kastidesse, mida otsid.</p>
<p>Kui tahta kasutaja soovitusi vaadata, siis peab panema kasti kasutaja_id (andmebaasis hetkel 1-5) ning vajutama check suggested movies.</p>
<p>Sessioonide peale saab vajutada ning vaadata täiendavad informatsiooni.</p>
<p>Sessioni detail vaates on võimalik valida piletite arv ning siis näidatakse, millised istmed on juba hõivatud ning milliseid rakendus soovitab.</p>

<h2>Istekohtade soovitamine ja genereerimine</h2>
<p>Istekohtade genereerimise funktioon alguses genereerib sõnastiku, milles rea number on võti ja väärtus on set, mis koosneb suvalistest genereetud arvudest, mis ulatub rea toolide arvu pikkuseni. Mida keskmisem rida 
seda suurem tõenäosus on, et see genereerib rohkme arve sinna ritta. Pärast hakkab algoritm otsima kohti, kus mahuks n isted kõrvuti ning hindab nende kaugust keskmisesse kohtadesse.  
</p>

<h2>Filmide soovitamine</h2>
<p>Filmide soovitamise alguses programm vaatab üle kasutaja ajaloo ning leiab žanri erinevaid näitajaid. Siis ta hakkab otsima filmide seast, mida inimene pole veel läinud, sama žanriga filme, mida ta on juba näinud ning annab erinevatele
filmidele kaalud, mille järgi otsutab, kas film on tema maitsele sobiv. Kui filme pole varasematest žanritest või pole piisavat pädevat soovitust, siis soovitatakse talle lihtsalt filme, mis on heade hinnangutega. Selle algoritmi jaoks 
kasutasin kaalude arvutamiseks chat-gpt abi.
</p>


<h2>Tööaeg ja keerulised aspektid</h2>
<p>Tööaeg kokku läks umbes 14-16 tundi</p>
<p></p>
<p>asjad, millega oli raskusi/võtsid palju aega</p>
<p>Liquibase changelog.xml filega oli mingi probleem, kus ta genereeris tabelitele lisa veerge. Sellele lahendust otseselt ei leidnud, vaid otsutasin kirjutada .sql failid, mis tõid tulemuse</p>
<p>Erinevate frontend raamistikega pole väga kogemust, mille tõttu routimisega oli alguses natuke raskusi. Osaliselt aitas chat-gpt, kuigi ajaga lihtsalt tulid lahendused.</p>
<p>*Filmide soovitamise algoritmi oli päris raske teha ja sellega tekkisid mitmed raskused, millega aitas mind chat-gpt</p>

<h2>Mida tahaks parandada, millega ei jõudnud tegeleda</h2>
<p>Üldiselt UI/UX</p>
<p>funktsioonide logimine ja erorhandling</p>
<p>filtreerimine valikutega, mitte kirjutades</p>
<p>Filmi soovituse algoritmiga kaalude katsetamine ja olukordade läbimängimine</p>
<p>sisse logimine kasutajasse ja selle loomine</p>
