package imageLoadingLibrary

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.ComponentRegistry
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.bumptech.glide.Glide
import com.example.demo.R

class GlideDemoActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView
    lateinit var btnGlide: Button
    lateinit var btnCoil: Button
    lateinit var btnCoilGif: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_demo)
        var gifUrl =
            "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif"
        var imgUrl =
            "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAJQBAgMBIgACEQEDEQH/xAAcAAACAwEBAQEAAAAAAAAAAAAEBQIDBgABBwj/xAA+EAACAQMDAgQEBAYBAgQHAAABAgMABBEFEiExQRMiUWEGcYGRFCMyoRVCUsHR8LEz4WJykvEWJCVDRFOC/8QAGQEAAwEBAQAAAAAAAAAAAAAAAAECAwQF/8QAIREAAgIDAQEAAgMAAAAAAAAAAAECEQMSITFBE1EiYXH/2gAMAwEAAhEDEQA/AAdte7RUsV7ivUs8eiISvdlSAqQFFgQ216FqeK9xRYEQmK921MCpBaLArC1LZVgWphOKAKQtS2+1XxQtIwVAST7UaNLmCksMEdqTaRWjYtCV7s9qJaBlJBHSvVhdv0qTSsNWDbK4Jk4oyC1kncLEhY+1OV0y1EOyU7ZMc0nJIaxtma2EHmu20yay87CNsgdKrltWjHnwD6U9kDg0AmM1ExkdqLWMZ56VNrUkArkinZKjYuKGuELsOFp0lhCUDMcGj4be22DZ1HWpcy1ibMzFbtvyRwKMFs1xt2H9PUetOzbQDJxziqxagPvQ/aoeSzVY/gJZxbGwRtPpT/TxjFArBucHHPf3ppaLtNZSZrGNDDlk4pRNYNJIWLHavQU6QjbioO6KWHHNZo0oRR2u2TB5UHgU1igUxgbagdm7Iq3cSuB09qpsEC3FuEOQeaXTIWJJFMLtyiBznFINQvJn3LAucjAJOKcUyJsK3qOM11Z7x5xwynI611a6sy3AAK9AzVscW4eY/YUXDBHKyRDOf5q1bMFEDjheQEqOlSjt5GOFXPyrTLpsCKuxe3OTRVlpqBWOMZrN5TVYTJtayqpYocCq9vGcGtu9pHtKsnHrS260lSCU/ahZAeEzgFTC4pzHpDeHkg5FVtYnHAOQardEfiYsAz2qaISf7Ud+DwDnIINewwhX5ocg0DrFEt1BVAWI5JoqVjLhQmCfQ1TEuQMdKaWdvEASRk9s1jJnRHwXz6emwE43Yq+FbWO25xvHUAUVdQA4IYfKgzbM3XmhPg2ipJRA/iRqAM5wO9CXZNzN4gBBPYUzWybk96g/g2+0zlFBOAScc0IloAt4Cpy2asntTOVOPamERtZx+XMn6ipyeho2GxlXDDBHYjpQ5DUbEx+HyU3K1L5opYJWhUEkdgK3AgIQbmJHcehpRdLDHd71bzE84oU7B4l8M0fGAAZG646UTAjqB4ismT0NaKRoZVAwCw56c0Bcq0kgUncfl0p7i0p+lSwhlPm+9VElPLRxt+Bnj61K6gjESEcZ75pWVQJGxXvTC0YEZJxSkoysQT+9XpP4a4pNDToavPs6c0JNLzkGhXui3QVSsrH9QpUNyDo2PrRtqwbg0tjYY4YZq5JNtJoaYdcQpNHsc8GlF5YQRLhMniiZJ/KfNQc05PGc04idAPgj/RXVbkV1WRSM6iO3ciirEbJQx61wU17HjccE1dmdD23nDYyabWsi4ArLwSFCOabWlxjB61lJGsZD5YxIOlQltOBtquC8AXjGfSrUuiW5AxWfTThS0Z6Y6daXzRsjEqMDOTmnTSpzwMGhLnZIhCjmqTYmuCd1WR8+o4qvwMHpRBTY3HUVJMkncM+9WmZtFlkiAFX4+tXF/CfjJFCt6jpVaarbQXC2skieI/ATPPz/AGooLSGatv6iiI4EPVgPbNZ631Rbm6uBEAsES7txbn7VnviP4rmKLa2kjwkuQ0iHqOR/ilo2N5EjRa18TWens0VrmZwMlui49vWsNd6pcanJNcXrnZHyqA8D/eKp11fDljCtlUhQeo9Kos4FSWCKRQxc7pPMRhe3+T9q6IwUUc0puTN7o5lXRZJYI0nkjXxHjKnOCOD617d61JbXiRWDtFAFDbncsef9NB213c6VbWOqRTbkCPEzDj9OSFP0xQX8Qhu5Jr0YWFJmcDbjJP6FH3Jx8qy1tmu1I3tlq5eGbx/P4EhjkfgE+jfKgZJbea6Igmjkxydjc0qvLmdNKW5tQE/GwK7sw45Xa3yJypPyrP3GoLpsGFDLdso8Q4OQeuPvUxh9RUp/Gbc715RvavLcOZNx5NW6VJ/ENMhkuAsF54Y3r0D+49/auicb2QfqB6d/tU2UGlEkTDkAnjNUSwqFK7Mj1r0TqpwwG6pG+VcLs/7Uul8FtzHg4VcVQI+eaYXMgkco0bqexC0OphYHaeQaqyaKwVH6UqL4J8iE0ZDtAJK5qXixntiiwoDVNmTioGYE/KiZ3QLwRSp5hHNhsMGPShdF4XyylRgihJZdo3Y4osW7zOX/AJcdKjKkUkZQLtK9/WmqBi78aPSvKmbJc/rWvKvhHSoxyHbjAqy3hV32yTJEw9QW3fam2ltDcSSrGvhtCdu4x5UnnHXvxR9pafjk8a8WJhkjyrjPvUOZSgK7LSJLktmWOMjoXBwasvLY6agMs0bk8KIw3J+oFaKXTLf+HxwsrDc3lG7mlP4G0S68V0keOHhSg/U1Sp2ynCkIbnVEs59kjlX7r3Hzppp1495bCWE716HsSfales2tlqGoncpWRvNJsPmI7AelPba40m3SKFEMf4dfDKqegzkZ/wCauVVxGcbvrDLeF5AGL7R3B9aJeykChhgj1BFIJNSSaWWAeL4YYnI9etLL3WYre4MMlxhkP/SD4IPfNRq2XukaC7h2zFI8sSPSl91exabE0t1KqY4AY8k1n9S1bUfHMBV0kD7Sick8jpWcnN0txL4khL5/UTnr71tHG2ZSyIa6jr93ds3huyIOQpwvHzPX5UJpEni6tHLd3WxF/LZ1O4op4Y8ex4680vvbx5SGeUs6qFDH0HH9q9ij8FImkBMjHOMdB3+vNa60jG7ZrbTSZNPvLq0u9St5JCuEKkksuPKftx1NZ/R4Yn+JY0nUyxIdxUKfNjpzjIGe+O1FNc4VL6dRvjjVWyP17TgEfTH2o34UtCS125XwbrNuoVujEgqx9sgj6H1FR5Zo+tCLUvyb+4QNzbSMkaP+s+meMcV1pbqsbceJPO/hhVBPHJb6/LpU9R06+a9mkuIwmZTn+rg+nrRM6mzvpLfIWGOJJEdOm1lDZHzzV3wza6MNJvBDYzaZqRHhXY8oH/45xw2fT/P0oDV7WbS4YYpU/wCpGsiY6ZYZB+VBz3UkkwiByjEBdw568EftTGWIXGnRW0iMt1CpSPLc9MhSfl0+VKtWO7Gltr9wPhaKFmiIsmDITyXw2ApHccj54oHUYEvb+11K2YlJsERMp8rD9X0oMReD8MNuwJS48jf07sce4PX2NMIJp3/By27JIttwV9OMVNJeFW36NdS1SaOO0EUW+Wcq6ge2Q2PX/tTG/uorixjvejeGPEXdyg7UHeaVd3Flp89tabmglZFePBUJkY4+e6tFBoMkVs04UNI4Iktm6SKeoz25NYya9N4xk+Gb/H3NiRDNidP0rdf09duR34xUdeE+qIqoxgtwMERPu3v2JatCnw7o0tyDJPJ+dEPyHkAZR6H/AHqKZQaBpkUYMQLIVA8QS5LAfLrSeRIaxyfLMn8N/EEtubmDVy7yxkBHHJK44Ygf3xTqXU4p9IN/dabKrodpZBjJ5xzjGPc8djTKG2sIJZVsofOwxLyeR70j+JbubZ+B2IqvIvhFZCA3LZz/APyFwO5JpWpS8CnGPoTGrSWyTWzCaJ13DBG4D3H+Cagsi5w+AfQ9aeWWiWH8IW2iheGB1yyKdpJ9TXuqWTyWbu8cVxIiZVmXBLD5VGxpqxK5jdSD6dhSuazaWQ+AjO3YBSTWq0iGKazhnaBV8X+nnafnV3iREzth1Nv1GeD9KanTE42jNWthqPCynwMdcruJHyFEDTYYXHiw3E2GAYhMAD16jIq3T57zUAt/bTsqwysskLJlZE65HvinkBtLuFZUzsY45PQ0OTCMUY640i/aeQwxwCMsSgMjZAzx3rq3H8NgP8o+9dS3K0R8wsNcvofiRodRjy0kTeJEuAsgJO188/y4+3rRugX7lbu3tLfFxayb2iUlfGQ9+fr1PQD0pdd2i2F/p1wqzkxYTD5ZWXgHHGc9foKAttbf+LPcwRILhraSCWPbkABvK3PTOAPnWlX4ZXXp9B/jZEM8d2EEkDFlkUnzRkdQADyOhH1rMa78SgxKI3h8FIjhE3eYngbcDqMg85/ansMVrqfw+l/Db3MV4qHag8rE4weD2rJWOgS6nLDNZK29wC0owNmcgkj+1EEl6GRtrgDG02LZ1ka2lkILOsZZdpPUkckitfo+iy6hb+VkjRyHmukBEjHkYOR+/t6UTZade6OYLD8Os8ZG3Ow4I7+bsPnRuo2pmjWC5vJUsxnO04HGQQSOT9fSiWS/BRx16ZP4g+JEsZJNL+H9kEQ/Lluict7n2+fUn0rHWoF3doiECJDmSWQ+ZuevPT5fvTbXdGkttMu5bMTOYmzIGA5Q8bgB6cdfU1l7JsPvPPz7muiEVrw55t300t7bCE2t0s0crDyTMGyMdUbjsV9/5fnS7UEkhmfcAF34LYPTPB5pp8NXkcF4kV0yPZzK3jIeBgbRz1/q/aj/AI7ttNht4Es5QZ48K+OrLjKn59vpSUqlQ3G42ZqzCLOJGAfbzjrgdM/OvWGxi3lfe23qe/8AehYJPAjUhM+IefkOmKMSQuY1Zdu9txBHJrR9M4j3UhaarppaJtsrS5cEcqcfPzA+vWqLGZUjhSRQIQDG4VRuzxg/PPPPcVRp0Ek8ksVvGzzMpZERcnAPatLZfDd28jR3Eaxx9QzON5z3C85+Rx1rJtRXTZRbdoS6rdym6MhKTAssmc53cDH79qWX5mmghAhbCLsLAcYyTgH6n9q+nQfCenQbWeMzSqqg+I3BOPT1o3UtHtfwEVrjaUYlRH5etSs0UU8Mmj5LpGlX95ewfh7ZpArg7SccDnPtW2tfg65nQwajcQxvv3JNCCzhgTgcgDGDWltIrXS4yTsUjAO0c/U1ZY6rHczyrbRZEbFJG7qR61E8sn4XDFFeiXT/AIWg0+6K3ax3hbO1WTKjI54P1plcvp9namFI8xjySFFxtx1PUcUHcXksqXss06xwxOBmNstnHY+vWqr6CO5tLe3tneWzRfGlWID81sbgD6/Lv3qXb9K4vBdb6gzX0Hgn8LpSMZBDCWYtnAVmY4GTzx0GM9c41Jvrm0khimRbm2lJ2yBvzB3HGMffrXzlL4395DZ7JVEXnOEIbwwO49e2flWv+GdcSeKxgumb8ShdlBQ/oIJ6+wp5IUhY5dHFzoekapJDqC2olLDBkR2VmHucgk+ueaSw3Vxo5uITp7BbWYyxxoCPEgPD7eMEj9XX196c6ss9oC2nTom+QBom7gnOVHrzV87pfbFjAM8TLvVuDg+3uN1Zf6asx2pa9rNtrcdtG9osJkATEeTLGehOD0+xp1Zacbi5lubyF2c+RerAADrkc9OhHHIpd8S6UqJDc2dntRAQ8u7BjIPAJ6j/ALCjbeO8ikVodQkaSSNUwG3okg5VifQggVbfOGaXejCzuTpyodXmKXEhwUjZxEqjoV65PTPrT/dHLHvTnjIrKXHxQjP+HYxt4se6OUZ2bsfpbjjn09vWi7XWLqYq8cSS27niWNt2DyDlRyOg+p6Vm4s1UkM9NeIxyoGUESHK+v8Aio6lG/hyssgTdGUO1OfY9azGp63b6XHdN+FlMhyzkZABz5eT34B+o9aZfxuPVvh+a5t5NkieVsHJXJ609Xdi2VUEfDcawG6xIdmVGD2wMZ/t9KKu0W0Sd4htLgSE5zyO+KSaZrFssry29xFP4cSx3Co6nGOc9eO/35q6fWwl5d2U7QkR4MQJG5kI5I7HHXHcUNOwTVDRb/IB3wn3Eh/xXVm2s7lmJt9P8WEnMcizIoZexAJyOO1dRQWxleyrLp+L9ZE8LG945CodR0II6/2pNq2hibUPH069CC5h9VxIeBluMkngbs5zTqWeCxstt5F+VnCTxoXQg+uOnuDSd42gHj6TPA0BKv4Ew5YKfMEPyyce3enFikhRDomo6bIZrK/uWaJvNuIVNw7ZUnGaej4hSG2ijn09bW4kAKJuAjkBGSQw9Offn61Tql0ZtNksI3/DSzAiRHbBOR1G7BHIx05pJr17Ztotjp11KTcw+ihlbAxjcfoeP71aVmbdGwm+Ih/C4p4G8KU/l4d8jOOTzzgc9aHj1KB9H09gFYO+GVmzu29T05z/AHrIzawLDTtOtIdpiaUObgYlC8YKkevPuKUaneK8QCxBQGL5iYjw2zzkDoO/1qo4xSyG41WG3n2ajZFooxkPG7/lFTwdo7cHleh549fnlto+oz6i8P4WRmU4LHhfvWz+DL63v5fCacuyoA8Jx+Z1Pf8A8uccdPegotXvdQ1G6kijHgxZVTGTgY4XaByenXmqi5RtImSjLoNbfCOofiFMkccsRjPCSbTkYyBnvz9a1On/AAtDNp5h1ZNhRhHCpAyR7joaqn1xRqFtbRPlIoy1xKzhRD+ktuJ9APlz17UNrXxfc305j0YCOCMH89h5pQOuxf7kdql7sa0SHFr8EaRGxe7Rpz/IWYqVGcjGD17Ueuh6LBtcWlspUhvEkUMQe5yetfOn+Ir2KCa0WUzNI+9ZpcsUbAztyeef707+H9XmlZba9mQRS5jYFVB6DJ57epJpOM/2UpQ/RtplttOXxN9vGoBwMbRk0nh1h9Rna20xN5hbbJJJjaGI56dTWH+LviC3v9SYRzOgDkBojvHHAPB7e3XNM7D4ij0XRGfS9OkljjTc3jP5ix74GfXPXoKPx8F+Tv8AQ/1ObVbZJZG1NwqttAEYJI7kYHHQ0vvfjjTre3QqZbm4fgR9WB9zWN1e/wBavYFudSnlJujiK3U7QvfOB2/5oHTNOm8UXk5Phx//AHP6j6KPT39qtY0l0h5HfPDdG6vbtHuLiSWFhH5Y0wRzxjYepP8AuKjb50+xiS2LJclDFIVGdj8nl+7cfSl0ut+JYWqrDMYUz4zYJlLlug9B2yceme9dqDyG/ntZroCFCkcShArbANxz754z79+tJId8Lrm8iSabTomeJwwMzHynOc4B7McdulT0e5lwgsryRH3foHnXbnsvGMehz+9LbRl1m8luZUFw0kixsiucDCnB68juRjPp6E2ytJ7fdJbiMrDyNq7PDOO5PT659Kb8oE36LJLsi/luP4i7NcTMpmcAgoMjLHHHPlHtmo6NqMs1141tGI5IYnIaMEojnPmC59OKW65MPFkt44AgLEu6g7nHoR06/L5VTFNLDaOyZiaTy5QHO0dea1q0Y3TPqOla1aapG1uxRZVUNIFPl8TqMdcUXe2z6xbLCtwYpXjCnDkP6gH1HB9+K+U6dLHaK0rl4wylY9mQfnz1zg1qJdb1TSobWOKKGW5uAqBZI/MhycD34yT9TWEsdPh0RyWumrWbxNKMOsoi3Phnc7DcjMhPY98Y+9Ya61QbWt7BmijKE3FsfL88eg5/xT24v72SG4kMaXMc7/miLLHeOCy4JxnHalWpaT4yQXOnsyxn8ly67jvGSOfRunzFEEk+hNtrgmtbdLeNo7aaWK2uDxtkz4RP9Q7g5+vejZfHgthIdT8KcjesqykF2U4w+O//AIj1zz60qGl38OHnt3/DGXaVZsAN/Tnt861J+GrS50OO33OJ7diSxGZI0P8AKfYcDNaScTOOwn1HUbu504Xb25kuBF4V5IxyETkDykYO4EHd2K8VL4Zv5YbLVo3lilV4lZ0csRGqkZwo9Ae3Jp58IWbwW8sV0FeHzW6EkN4o67ADxxgcZ+WCKzFjPpmifEpmWV2iAZJY9jLhXHVScZHPQ+nBbrWdrqNKfGQvtW0m/uorbSrI2cS5ZpIRtJc49TzyO/arLzU/CtrLUPBS4cIENxIxkG4A+QgjGSCefah/ivR20nU47zTQLjSptpjnQ5UMOqMR0bpjPWl+j3p3S6XNIps7kBHDZChs+VgexHrVJcsm2MoviEwxJErJtRQownpXVl3eaJ2jZBlTtOYz2+leU6QWz9DJbIliy27LJA+7CkZC5PIx2wfTpWI1xJtIvkTT2K7ukLuzErx+nnDDv6jim+ka7Csa+CwjaZmYRyNkP/cN7V2u20eqQNHAWdn/ADljBJaNxjO0ZHAODgEdK548fTol1cM6/wAaymKOKSBopSm2VeODjsD070sk/CXVpO/4gESbSu4YMTY5+XFGXVzDCj2Ov2plfxPyr6EBJlJ6bs4zjPPWmU+haZc6URZqZZVkRY5llVQ2cE7go9uevWtk6MGrAmtUPwyA07EIxZVHJOOev3pfiSN4gtrK7Mu1WjUkkdME8+nU1pNPj0rSAttqc0aLt3P4hyoA6ccfbmuT4r+FdOndIWlkAbAcpn1wAfb/AHFNSa+CcL+i3S457aC4vY4HhkhjZPCdO5Ur/f580LaXttoViXvHD3XWK3HLZz+pj6V78Q/H018JbXRbRrbA5nkOXIHOQOgJ9eTWRuCpVJd2+U/9RppN25vkRgVUU36S2l4Hm5n1a8Z7ne0eQxVB5c8cff1opNV0uBGSYS4z5wnQ+uaXae9zc7wkzQRpGcbEGCMeb0GT86hpFvHdX5Zo/EVAWSJuPE/5q2iENrC0N7JJMfEtrdV3qkmDJIB1+XB6URrsLwosVhNJJbSIMKvVie2PmKcy3Uc80MqwvCIlZZYditjk9+o6Ht6Ug0uSC8+IJERSbYZ8EeKVA46ZOck9MfOpTt9KarhVpkFzZSwzi2UyI+drJwevHseK0t/ay3mm3rQqpZxuaJWxtxghT6gDPPSk26JZXWa4aCKMNImRux/fqT6VSJprK1uZPEb8XebBHECQzRc5JA6Dp1+dD67BcVA1gpuZWmJ2wxsPFIOSfbHp2xTG6mdhPLp9wJoiqpIqKRsB3c5742/vVEAhg0y4HhxbJm8Mox5DEZ3njkAZwKG3rDYmTYI1ZgdijAYBccn3/wA030Xg9N4rYScrAJLcR5wSFAOScfLoO+aItphqyRtMwSaYmQTQjA3N+sZPYE4rHXl9/EbnwLNZI1mcLtdgS326d6+gW1iqhZIjERFEFgRT5cKB3xzkluaifC4fyCobK00z4alSEBZ4lMvijO5GAyR9g3PqKTa98TQC08G0klMKqAxlYkzOp6jPOKh8canGgSwtZmA2A3JU4ErcbQR3PA+x+qPSbBLqdbvUVYxphYYR0b26cgUoxpWwlK3SA9L0+91KcOkRO88s54HtmtGun2pgZNTnYR24J2R8A+pPqMUZesVaFLEKryMVKZICjkY+2eOf3pdr62z6bbtNKqbd0bBHOdgOTnPUf5qrbEopCu1xe6mjRlbeJ8uA/wCmNFPB+Z5/ar9Y1K2dJp0uNqRr4VsnWWVzwXOeAAM/2pEL83bsNoVDnK4ycHH+BUtNsn1rW7WxgUyJuDSgHG1AeT9P71pr9Znt2kfQvh78JqHwtam7TwnVNjENg5Xvn5c010u7jtLYOuyS3dT5mwRjy4+xJI+Z9ay1vpGrppaRWFu7Qidz+sZc54GOvA/epQXV5HIPwxFtMpBnj24jfqMFTnHbp6j6c7VnTF0jW6lHBdpcqhMrSwmSDDYaORRgKP8AmrLbEs8TzhVDR74ZB/IxBV0b/wAOc/L24rOfiZbqUTaeixX1ujGWIFcKR/MuQcnHY1RbfGUsbRG4tlgtHXa6IudrnGWI6jJ7c49elQ4uhpqxnbCfQXls75G/CTEssiOdqY7D0wBnNKtT0eD4ikNsZMuFY2d1HHjOCc7sf8Vo5plCCW8uY7i1uSvBPk2Y4YA9T2x36Gl+oRWtvugtWMIchxKjN5W/lYZyMdsUJ/Rv9Hz2G51j4QvJ7S6i3wyAh45QXhkX1weOuPelsrQ3creEgjDnKp1H0r6VHIms20tjqMDu0afmSsw8TcOBjnryPbjpyDQ8Pw9a6FqkFwEKWtx/0pTHgwv6N2AP2+Vab0RrZhxourTAS/wu5k3+bfsHmz3rq+xNrGtIxWKz07wwcLh5jx2/lrqW8h6RMHHqm4yPe2yrs4aQfpkkAH/pP7Gov8Z2do7zWx8WdoyB1yW56Ht16j3rC3V9LczeIFaKL+WPdkY/uKiJsMS0g3EckjPv9KrVE7ms1T4rudeiMcun26soyZmzub9uaR23jwM52u23OV3FVyBwf99RQcV07Hais4C9CO3++1c11NKdu1g46KOfQH5dB2qvgm2N33hWmuh4gbaeXbK49TQM82+RnKAqDndxkg1Wt1cW7ArvLA5O7HX6VQ15MyMjEDJz+gf4pksviVhITISBg7V4I5z/AJqttoDKQSScA9TUIAHkQTu5V+Tg4wKI/wDlmuxHEN0GQAzHt3OB9elMVBccs8lh+FgDOSwLkHqAe3v04HvR9gsc7rHM/hTbsHcMFD2x3z2oS71N7mZo02R2hf8ALG3aFXGOOw/z9KNtVRdPKHxPE5eE78MoHOR6j/ihsEgq4vZpb+ZvELsked+OrNhSPfp+9U2GpTaY0tuBHGkg/N8QcKegYEdOv7UuXxDbvduW/ObdnPUD/uarhbx5Q1y5WFctgcdBx9SegoSBjHxUub0SBRnAkuF/rI5/9/nipWE80l1cai4cZcb9i5ZY+c4HpnFLkiF0DK7sC8jNIqA9/T2plL4GiQrNEZJjPG42OQNhyMZIJye/pQIv+Kr6Fbq18Fy5WMM6jgkkd8f2pJqN3JJzJs8YjkKPKi9gK8hlwPxM7Zc8qcDr3+VBMRLIXYZJPNNEvo2+GYx+PjkwSc4GR6itK+tLpsCowKr4gkjC/wAw6EftWU0pjCRKvlUc7iOP9615qd69xeNJEWWAsfAi6lUPQfbFJq/S4ulwJSb+LarLPPKEi3FwrNjj0HvWps7gpE4Z8MNyoQRxxxg/2rH20SHeQRuHUA4PWm1rMYppUnRnggzkB8bj2GfnSY0WSXcjymSZ/MhyOwBPbH0/aqpLaOeKWSaTfIyEbzzjvxQcXiOfGK5BY4UDAXOP9z7e1dq18Irbw0Yu7+XnjHaihGeWRgMA4IGKP0JJH1CJRIV3NliCRlRyR79qWsQCPtmmvwxN/wDWIA7lVKuq4HUkdPrj/iqk+EpdN5YarLYKI/EkMW8bRE/CnGevzoX4r1I3BF9DL+HlfKOiDJZcDJ/tVMzLtyjL+o9R1+VLtSnS0uwoliyqBsHzKSR5gP2+/wBskjdvh4zQtaRSW18YblvKwY7dp9T6fOrrybMCxyRDxYUBmCDJ6DzgjqMf3pRZ6uq3XiSKrNGhULgHxF/pPY1Yt7NPcLJbt4BGRsEY2nJJI49Seewp0IZWmvG30+SwuPzISwaIqc+F649j6UZa/FRnjez1hA6ucrKDgr6VmbrLGQLCIyr+dF6N7gUAZpFyEYr6cUqQWz6XZpBdLGoaPxju8OZlwZkXGRj1Hp16Hpg1HVfjK3tfhoQcPqZJiaGYFl2juQaQWvxbp8um/hby1nhlQb454DlklHQjP1+hIrJX8r3V3LcSou+Vtx2ipUe9G3zg4/8AiPHG2X/1CurP+Ga9q6I6UzSFyvmGFXaB6Cp2k7W770VCSMHeoaqcY7D714CPUUx0G/jJRgq20+1VvPI7bnkDNVAIPeveOwFAEzK+eGI+VdvY9WB/8wqvHNeHPtTEW5O7O5R7etckjRsGU4I6EdqqHuBU1JHy9KAD7dsn8z9RwVJzgnPf2phLO0BjheYSRBWx5clSeuM4NKoZycwqMo/QE/pPtVhk2JsfClV27gM59jQAVJcIdLtw0zCRMqynOCp5/c80uMzMQegJ6VXPcSTuGkPTGABgD0qAIJGBjHvTFQ7t7kGIgOokZvXt3q6/uI2jWGQ7Q0m7JTBX1x9qSxyBdzP0B5xVl5eNdMNqhIlGEUenr86X0VFlzO1yqhQqrGNqKOw969hXtlD3ahVJ9P261JpxFkbRux69KdioKnkMESJ4ihWHPOf99aojlLeHtXanTLdc0Ly/5kh4PSmFqRcWVxEVJ43qQO+KdhQQkYMilBskU5KDnHv8q9m/FTAyM6ksxDKvAb3PvULOYYGxio4BGP1dDzV888eze+RweR0pFUUx3sUESkTtvQn8plPJ44oKeZ7uR5HOMDHHYelVuJLh/EkIC46nsPQVN3IiJU7UB4HemJkUjXxQGccdfnRVtYO06uJFRM5BB5OOe1K2bCsT1PSuimZTlWdcjkhiKlgkbltSSS18LxYQBwjEEEDHORSnU0N3LHPvG78OpPHUc9B6YpVHOCn6mU4xxnkVbNcyHY6k+WNYwud2F56fv96k0Z00wiKSJEpIOCVPB4pla39jLDHHcSPayrzvUllftjH8o96TOsb4COy4GSrcDPtUJll8X9JwegBzTYkaC6QzEu9ykiliMr50IPcEdxigL+2a3Yqy5YHGUOQfXn2oGKa4tmbwpGQsu1xnhh6MDwfrRcV6kiKk8kkWF8jfqUHoOvIFIYGwOcFfma9wCOG2n1NX+E820+UMSF35ypNCTBonKuMH17GgR7tb/wDYldVW+up2BXx6CpqQTjYv2ryupAdJxwBUF611dTAsAGelQk4HAAr2uoEQWr4gCTkdK6uoAuiCh1IUd6Gmcu7Fu5rq6mBJMbRwKkcY6DmurqAIycJgdK5ePtiurqAJsQqZCjNC9XGe5rq6gTL+p5+1G2UpijkKqvI5B966uoEU2BLT7e208VO6mZGROq7ScGurqCgQzs7JvAO7PrVl1/Ko4AHSurqaJBj1Ht0qYOSMgV1dSKLgSj4XgYryEkMvJ5bmurqkYdcnwZyQAcLu83rXsFvFP+pNvP8AKcV1dQBK/sY7ZSyPISYmbzEHkCgowChcgZGK6uoA9WUxeZAB3x2+1RLGaLz9VPGOK6uoAHrq6uoA/9k="
        val imgurl2 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png"

        imageView = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView2)
        btnGlide = findViewById(R.id.btnGlide)
        btnCoil = findViewById(R.id.btnCoil)
        btnCoilGif = findViewById(R.id.btnCoilGif)

        btnGlide.setOnClickListener {
            Glide.with(this).load(imgUrl).into(imageView2)
        }
        btnCoil.setOnClickListener {
            imageView2.load(imgurl2) {

            }
        }
        btnCoilGif.setOnClickListener {
            val imageLoader =
                ImageLoader.Builder(applicationContext)
                    .components(fun ComponentRegistry.Builder.() {
                        if (Build.VERSION.SDK_INT >= 28) {
                            add(ImageDecoderDecoder.Factory())
                        } else {
                            add(GifDecoder.Factory())
                        }
                    }).build()

            imageView2.load(gifUrl, imageLoader)
        }
    }
}