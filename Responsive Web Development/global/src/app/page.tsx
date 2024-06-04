import "../../public/css/home.css"
import Image from "next/image";
import plasticos from "../../public/assets/plasticos-removebg.png"
import Link from "next/link";

const Home = () => {
  return (
    <>
      <h2 className="titulo">Você sabia que plástico não é tudo igual?</h2>
      <section className="sessao">
        <article className="artigo">
          Existem diferentes tipos de plástico, como PET, PEAD, PVC, PEBD entre outros!
          <br/><br />
          Nem todo plástico pode ser usado no microondas, para guardar alimentos ou reciclado!
          <br /><br />
          É muito útil sabermos os plásticos que podemos reutilizar para uso próprio e caso não seja de interesse, é muito importante que descartemos o plástico no local correto.
        </article>
        <Image src={plasticos} width={400} height={300} alt="Embalagens de plástico"></Image>
      </section>

      <h2 className="titulo">Mas como saber se posso ou não usar esse plástico e onde descartar? Era difícil, mas não é mais. O nosso aplicativo XXX está aqui para te ajudar!</h2>
      <h2 className="titulo">Não pode usar nosso aplicativo, mas já quer ajudar a natureza? <Link href="/reciclagem">Então vem cá!</Link></h2>
    </>
  )
}

export default Home;