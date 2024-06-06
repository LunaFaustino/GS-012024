import "../../public/css/home.css"
import Image from "next/image";
import plasticos from "../../public/assets/plasticos-removebg.png"
import Link from "next/link";

const Home = () => {
  return (
    <>
      <h2 className="titulo">Você quer saber mais sobre reciclagem?</h2>
      <section className="sessao">
        <article className="artigo">
          Existem diferentes tipos de plástico, como PET, PEAD, PVC, PEBD entre outros.
          <br/><br />
          Nem todo plástico pode ser usado no micro-ondas, para guardar alimentos ou reciclado.
          <br /><br />
          Você sabia que papel higienico e  papel toalha podem ser reciclados?
          <br /><br />
          Sabia que há um jeito correto de higienização que devemos ter com esses materiais recicláveis?
          <br /><br />
          É útil para o nosso dia a dia sabermos quais materiais podemos reutilizar, reciclar e como higienizar. Caso não ligue para essa parte, é de extrema importância que saiba os locais corretos para fazer o descarte!
        </article>
        <Image src={plasticos} width={400} height={300} alt="Embalagens de plástico"></Image>
      </section>

      <h2 className="titulo">Mas isso tudo é muita informação para decorar, né?! Por isso o nosso aplicativo XXX está aqui para te ajudar!</h2>
      <h2 className="titulo">Gostou do nosso aplicativo? Já quer garantir seu lugar ajudando a natureza? <Link href="/reciclagem">Então vem cá!</Link></h2>
    </>
  )
}

export default Home;