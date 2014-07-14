package gilberthouse.random;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A SIMD-oriented Fast Mersenne Twister generator.
 */
public class SFMT19937 extends AbstractGenerator implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8817611212977197798L;
    /**
     * The jump polynomial (2<sup>32</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_32 = new JumpPolynomial("2b65c259c76dde136a73b7e932cc0a5e528cea96db0857e7a15cb633627d0062d5f014ee6c33d87d4d67f801459cd50763832cbace77bbe634ecc500428a74081af81a0dbce12b92cc6711879c3bb2edf3f58a5a844c2fa781ae9b528f5ac1fda0efd426d10315327fedc4a8abba328b35b066c11b31effe89528a3e61052f12b32118b4305b1cfc30ab45209220d0a1c14779cfaee494d35868eb3116d3d72faa285b4f05cc54b279aa0c7e99f796623b7e845054f4981eff617caff2280d1a723938907e2183e1fc7db8043a81115f12991d997df9dc9c403fb7b55b972bb2869ccffa152ee2af3f116e2bcf21c6a2d8f1483f39d0cd20c2eb606969f357405985fb35574253ca020411e2a089aaf324a04f02d42f5fb07df9bfa550949729fc330d508f7a3fbcf1cb30d01b4869f601c34ba1b87908520714d94b0d746854346cc92a40d71ecad02498dcdcdc014a428bee9d60ead38777fa5fdb800e8c0ff111c9410390147a155f0035a94c7860dff6b69f2845fb5635d8f14c4739a7e92f2497bad2669b08196314fea53e5c6fa32b360d7db8658bc0776b7f07870cdb11af541637ccca9cd3eb126103b46c61519cc1d606c2046ff40ae96e50f2c9429bd81a6eea24ff30e7a0e9ac022d35022baf6e2668e664be5fc87a317f9a1f9f2e522c3fded4cc9f177a44049889f241ea6444572d1c8a5de88a899fcc16c571e291dc3e0bca2ea680a253be9eae602c85f3c6d34837f4a7b68b856b51b3aabfa57f81c0bf7d6855006b5a99e9f506e0a59fdc8ff7eb239520336d2879bbe2dbb875fd17aa00ee9c488ba13cc1b31aa47ed86c1abdb1f75cea997682561ac06516b7ce5ef68b5235abe5495b01d0989eaf9ab329b86dc1ebca5e25f723c673a42f21e3d336062f6582ded675d6eae0a952366ed940090082903f8a30ff71b1846a79631580602a9209a7ee6b2840b0faacd05e8150d68a8b26a723c7fc9ac21b85451e2a97a973f23a0edc6bbce2c9b5fda0f54129b899c8e60c7949b81d5fb7c2cd40969f4fe6d9b2695aeb5c1dc870640fde5c4afe425d3aea618f15b88498db9b09771fa378f9fb7bf6fcf9d154fcf84499d3822410f0df04d5785afe8c9b3bc209ce3540d666bd788ce8fc8f6e8861a2a32b6af6ddf1a960eefb0ed8cacdf278fa77842bdee23299d3c7f109297f5bc31a70093826018ec051a74b720c51595a95dc7d1017a03927e5037191faa104804cb94ffcfd89e0d556e39901176f93e788970f14016dd8584b813cc1760a454e066701c16fb96a05c113b58db58bf3a3f6853c36a3dc42336faf11a34e2ce85e6274acb8a280f47cc2974b72e3fca72d2eeaca024fac4ea2c96eeb892196100586b4579da6ced7eb6a70f99916cbbe62b00c643f4723608c909af6017b2ab190e22a73f3cbd6e7a66a4f1043824a9f7941f18cd255251e39be83ef2b3d25694e3e9c29be42278bfcc7eb3ed0639a90334592421539a9e9aaddc8348a583aee948a891bf377beb9bee8b86a924b27066bc1afb7763267ff611ac5d1fc6a550aa4195cc26f2149f4db6b87f7b2d9473fe1bbeb02c54c2bc08c95e28e3961a0df19b1c203a63d31b40e0002f95922d0d045e3c992bf0d18c04a51ea466fc2d2e7afa264953b12a7d07b4a2457d662f963aa9bf394e6c64e5cccb953e4e0e45f50ea7058686d24f88b34260712ed58a1aca5c39b393c055fcdf4627c15e83e41085fc96245f4980f7d789fea9dada6d76ded6e6d1a262b0aebc5ad135f4ceab32466708f59f50674c7e8698d61c14be351a47615366f667f53a87132fde5c97844b4f7d9e986c635946ae72ba5cc4cab115bebd00b309c06d38fe12429b95fecc7938c7aa8b6df0ab0b44435b419ac5819b3a3da566057a16db7ce6e393831717941bb0484b235030444a628d1d9bb17c3de3925eb9536a9fe87229bd70bf9ba58cd15915860840cc032d06a8200656560f9ecd1722666c9758b25fe63907c8bdacddbcaea7db2ca18863235f1b609f91ba2a3d7a0fa8eb60638fc38df9d6cac5499919b347a26ecbdb12afbb6b5bc88b81cf432eddf7916a7b70eb95e4b95e35239e6d88389b1426ded7449eb1ba16e584352bafef0cd17ef23d2863238f1f73bae25afb8ee5b1fbc2f8dfa81dfb6737f5e739a6ffbf9ac94196332c9ad3a008ffacd442dc449dc31e63295ca46cf4b4a9117ab5abddabb89e51917eae76212e3dff9a12477950bf8a56418baead0f34183c450b779480b254a1045ebec42ac1b98da1d3c1896d923e1e1cde84f5bdb476ed2761f12fafc092d2f3a7b78ec6f5b52b5faede2a4f69b64b52bb4a25619c6712defde5a694844daf0ced30d9ac552e4968caa727efe15a6b7dcdf23f28131248f6911dacfbb99ec95290cdb6cca18ff55d0a87e4e332d64bcf5efa91238f8927995b79a69154455a6c3aa856221c99ed5aa48eb197e483c4937c56ead57fd5c0a63eecd1e0b215896d306ed0d0af92e16f5721fe8cfee5df6c6e1c67af60a5a6995dcb1c0cc1449e1c5293b3dd6f2a326cbb0565d31391cff4b9f56b1ae3b33e0d52d0450c8bde3a7b167f500842f16b110cf04bc2ef3d9337b2e2f061297849e54b432bf0d9ccc0fb98ebc79d151d3a49b17e2160b01775c04eea7b7222ff27c77399e3a6c7466855ebb6acfda31246a06b29f328998f2479311b751f4a048041dcc45e29b21cd74579d9266f6097c1d23cf2f7a76194d96ea18cbc00042e3c25483d15e68302dc429ba2e2e067ca0cffb94c6614b802e0a7134c20face001c18d45b6c80b75851d5d645fb85f463d828ff30cb8874f0a851fc2e6efd424703bba21349b3cb9cd0f971618af2f7debe0c0c4ccd00a0b5ea5178b505669fae208adba7e56ff4c0778ceaaf09ff9a276308fe40a4a33de8abff434e0df7670f72ba4314bf91626c854990088302310f481393fe43b99a1899993419cd86f0e6478206fd982578d06dd136b92a6a14b7df3ba14a77c86a57bd7734e93252e9c66b63b55c7e2acc61a57f47493f0ec72520e9841fef876ac395d6c08d93151e0b421529c2c40e5475485b209397fc6158e8c09232d063f4f6b47d7a3e50a13080661d9469e1aed3a78950274c6b382742366a42d820c260c2fb0bd1e4596fe241cb0aab38e22f6888e59aff310bfd24a053a22b5e1758be16205b55ba5434bd3acbe577c1ca0e36dca840547261720d7cb993b95211cbf0b845d93017a3ca9544ef6649a456f1938223b88b73b7ba868c112e68e1e520223407908812f78ee61ec770b302854256bbcb550f6cac703a1978b28664957dddd71854edfd14b1dd38e36e23f681992a83f435792eab843cf78fb30fd38b83875e52b5e3d1329aaa5e4cbaa33bb1cb302fd6462070eea0f87f95dc2c1436b9a72513d50b8e325b68f6c4209c65492c46a733e57ebb7753f130430c3e85dfbdb161e0940ffc149b062d448027c3edae5c52d19f9a13199155600488fe4eca44779531555cfd2c86b");
    /**
     * The jump polynomial (2<sup>64</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_64 = new JumpPolynomial("f83ffadf21a3068912f9b45a191b2a9a89b370fae456a555123b9522ebd2e1abaf3dc92c5c403b377d652399f3c3c81618ddd3d90ba07eb84a3a03de509541efbef1754d195dac1d152278ba54f5ca4487d4c0f2ce9a99079ef1d302ae64b0378e5a865f0be16dbb7de7d5d9e9e0eebc97b97cd9217921ba77641584b33973644a350890f984b984b8d5e60cdf13e4c03606b35fc43ccd1173d6a07931af3362fb7eb4a31f259cc72e452068048f376ff8724e9eaa294f20d982a1c774ef321128b85cf6db2e25b08cd06656e39f581233e01e9c6eb454a59d6a953210c4a7bd65008ab381d034d6c11bb34778cd4b49c2c96ff453b35d8e9cd906cf984b22bf1c6cdbb222f5d6ba8821779bd17dc4b4e376f5951f7ba43bee7258652708fc7c7500d0852d94a6190177be076556835cf477a5b6c2d118d61998e939b3c0c655c403b29a20dd8dc6b69b90b0d706d65fa609738ef0cba664623f107a311a4ffd74f9489f542412a4df2a8de7ca0201db218fe9a8c1948c097f571ffa599e317075ba7201a1a735c29a91ba2e2de1cbc993bb8e0f8ef26c479080c3ed6d8f26a103e95851e22bf7d05495076d6f918d52cf1fdd7ca5285269678be37b8290d6734f512e6a30a148d16c98375f9d0611ff19efb3779608ded1ec0a1411dadef2b1209daa341c45c1e41f3032c5850d49ec2b2e1da44e7d03eba9f22b2a57aa3d9e92580ddf4e4a1ec5b4cc2893066660bf6bd609e6def128cd88875d6661dad81d68aeb78491d5c5a81b998632f499493d4acd1c34d25848306622d121108c39e10f5adba33bbc58d1adb3ffc8fcdf5729072f85dba9edb1a36f544fab7604c43eda84c096e574ebcdb24d75827bae1ac64b86764f06f86318cf18172deabe01d80a945aad311f7794af4823f22be87e0a61abf575260982501fdd382d330bcfede57463e438a6338fe44b7c14830491eb3b973e41c5854b4bb72c2d2c7454b1a19386bfacf9016bf12ee095e442b71e5d7a77a3e736462fc949bce0ba63459c3fdce9dcacadff847be4ee78a1f29bdb7346427660ccf8729d6eed3043e5e70c2e27c2a54cbb5aa8c37229061c2c9caba1b30291d12bc3d2f1baabd06e079c118f8f4946c19fa62be6435fcfd9f468d443a28bc09f0ff30dd35679b8ac3068b683e2038c4f79dc7e2984bbb0164f9c75fd458567b68dff4659faa639e2539599d8f812f706a2edb93880a4593df713fe0d21aee3b679e4ef10318c9da1b2e29377ec39fe7468274de6064b238d1ae7f8e7d8226f13d0a616c7116e1e0e09a41a35e0b721933a6c4a8f4c63525a5a8cfb0ec214d17191b59c2f0fdecbbe3ee7912afee0b45948d6a77e8b74b57a8580bae0a7615d3d3e0a3a6f1afe46b9c47f1ceef02d2a19cc320a4cd9c74bcf0a0d0865b13dc65a09dd7759e374d23f897f0156ed642209f92fb1fe001deaba17860543eb97fe259b7b743b72c55472b51653ba781c49899051623c2a191e7ab60fdd8d9073eddb1165b334df4eacfdecaff38630b349bcee8efc606db08e038e79c985a3ca95023b8ff83de3413bcbd115acea30a8d3ee157a5e62b6576515d071bd93f1c29221f0f39b0fe2a30e5a843afa82aa467fdba1b7be85952463308b3489f2c95ee42339a0c8d5475a3a7f9441c3e9591be57f4543a27e61ae46d886bed5e14145a532173d7bb3056d8275196450da2c5e6fda5d459b677934cc0b47c6972032990c5537969fc4b6d39c6942b2f913edb36705a40ba0e143a64899111473e39418b92efd6e0cd5e1248380893c63a48b668b57e45115fc0f4683d9751693758ec53ecfaaefda9cd3d373ec4bea780dd090096d52392eee27720c7683997e7ee89eea2e73312d07efa811bc2efefca771d0ef51cd1574d18f4a0452c5eeabdfb97a05c8054b5dfa1f05f0fd985616b3ea02c57c76f1b4eed32109f5413a451ddc4e4c8f3addf5886c3836ae9892c5047058e23b80c24ffc52a583e2dd51ab96beba2991851b5ab666465795a4ef1515ec41be094344fb0d457275451702d5b73e905164fd6974d244750ab5ba44dd35629a6ab41510ec86531a25bcaa6ffca6aaa213990966a88fe394b9b55ce9e1e3022d35263106218392d7c409039fee99a8abdd2893a092a29691dda8a0c55fb18a6b1cd1ad102c2817defca395829281f67cc1dcb2e88b733376aa2e02a1114b866d14aaf5796f93e125f7abea1ae350ca45fe78780e002f07118f77cef00138f7654d0f6996721b20b8fdddafc1314e1697e5a6d7cb664146436ec34e246d44b729d1d6a54b70ccb5af50a94397a523373fdc28be365633f8ed91ef088c31286b3755d5b305b0196f26e827e5e6eeda8b8f23169dcfae577c18a458eb7884e25d842e55f260d13dc96d53fb894049b5debd525940a7fe742e7ef9f9bef825f4cd915ee2712963b11ecc677cf1e76d596ae2300a5ee3856000f46134215af182376c3cd1c389bc80cee4dc172b0471a6d687553e5a0d832b214415732beebcb031f40ecb5cce8c7513362e889037486c1f3603de73dd5e1dc6692c86be64dfdb4f8fdbe1e6825ac56dfe2c86f172491daae4296ed0b60987aecbf1f8143e306bb4b4a8b56aaef3732888e654ef478c10a448c7bc021be3cbeea06ef91df9550fd0e7fd13a9b5fd67cea8eaf340ebefb80ff0155b18ed202974d5bd0050393bc6a6e264a4224420eee0d747c29582bc388df05457dc1c5f02cc3e31613160a2e7286e82e6b098e9ca1dc1fa51e6e56e025c855f0183b1b348b1583cef5bedcea1f526c72f60f77ad1c844df225e2764f68b4eff76c49b5f5c7e148f59837124199862e1c416eeac2f28542ec71ce8d1962e6070af5fb24384704b4cd390ce9a0aaa9e9a371d7781083348feb26fbb838fa1c86ec69f51211651249f4af53b18f5a716f72695f7064a66fc6bc693bf76aa8906c61efcb5856aec06d3ae099c60515056ab39a37ad26173ee55099601ff0d3e8b94f5046fb14461604fc9cdb633592ade2f8d2b1ee9d489fbf08b043d96e8b0cdb5d14c6bc943fde82d3973d694d07e5bc707c88798c78ace134324dbb8614cf8ff1b65d5a7ad98142b407357b8a6b5b8bec210a7da418dbe61c61a6c3848e2b2a2178c3f21ee60ad7cfb7dd39f205e31b39ab00dc4d6c23898496291bb739f854cc96037df2632d129257008b75092dac2656585a98e99777ccb2eecc3ed758723970bd4a19884a23fbd5ad6e879f72bd107c6b3bea26a6b68d29b5f1afffebcc6239141eb5d9802921953070742f69c4063510ae6c224de30365ac4cadeeeaa345692a98bc7a98e5f4dd5b538bfd7d1e84d20836ef8ef3f14032aee5eca9b22d59206ee8e386fd9bfdfebfa081e89c77c90be699c8fb15a9516abeb16054b0a10f15150377a5ed4c023efb6b452dfa1dd6f79ac0ad750c4e30730b7505c397b2c6bee1fdba3a2a7b10f70cab16d51b5d0309d21ac9b414c4989a1ce4831f49414883e95992d5bc0528c47827b73");
    /**
     * The jump polynomial (2<sup>128</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_128 = new JumpPolynomial("6027a79f3b58b068e6780f3b55bbab16e517faa69e7c7e0f0fa77d7278bb3b94a86e0ad398ed99927e642a4cd2b3c086609495870ba3814886ad0c0716197052118dc68f4431bee1dfb12e2c353ee200772ef037e197264c26ebc140d004fc55276abb1286b03ea85191057aba65aa0165d5de7783716f1811e017129104e42ff95b99da3fcd29599ae0b201473622193d325d8644109c4d3468e96040b38e72c675d3ff1d7fd557e5103d0a60abe398d1a86a07cd6618025769b09958eff772124f7a9f56af405785aa823367f094d2896bebeacd905c96fca70d2682f28fabe779f280efa7b90124f73184cccd49607239b55372b7fdf73e0037cd894b2248daed23b84e17fb8a805494521d7edd9a4eb3647e6648c7a52f6a90e40e13269af3112d40629302048d2e14ff628ef0ec43713d70a1e11245924fa87693525f53c953dfc063e5474468b9f8a24ed30b2f9d9e7333e63e24109417628fd983343d592c0c320b73e4c240597159d1a401f91a985094f8db2e67cc0172b5f16b731fc379a214172de96fe7d21704e5f80f18e7a3c3fa33d5d624c57a87cd79609555b72f1936a0d1bd4bd619107478baa48b181363a0e3eeb33e5e3add379797c6480b35a9d66d55b4d8c64900fc35cf3b25022e8bbd4d63638da9a344fd6e37a2aa0bef7cc3b52dcbfd84d569a46d393c779601c577a79adf15cac012d94382dd822057c141ec4a1287abadf756ba67b37204356bc7c6e30ee937bf8423b231d1e3d9cca527bf67fdfbcb188f864b90d9f9acda4b8ae7d8a1b5e2f4bb7172cec13c2d2f300ade4a336a4e11818c422c80d0e26b45a656dbaec8c510d70bac712f54547e02b4ac0a8ed1f776a7c8ea2727fda71da683a085f95ddbac1d7c7cffe9e9a1cb696d3b235851de7247904888d56c749aa79e1b774bb93680b74efe7fe96e57fef17d621ee8129004e7d8660778a7f1d6a8503442997c4236fe8f64e0c6d05a5a4e807cad74075331748b93f8d25baae003778abdc66163b578183891a541b30cc7e1bb48e6de22e2361c5bd689878b40f2a0cc78cadca15750b9dec76e9a8ba577a7d4867589e88f44fe8a9e0d8c9dd096ff5dba52702e3cde97690509d06ad495337011c3185b731eb9009b2462a20417706a344a4cd85817ce9225071962ae440d917ea4acb58affd99ab9f9582ed90eeb6f3ca0bdae2efdf62b41b19e47cc2bf15650a7884a39e04e6f7745d68e83ff66b029912d7d285ea3d84865bfa658d17138b3341e394610296d9d6a8afed916152bf58e0f8c1534a5c9925cf3d6435d061253c7ccf4121a7448b715278c3e8045287a37a6fb28abee71b4f03139652a89dbd54f7cff69b5de64157285799562eab4c157422783b0870a5f8626fa7e63d28fae17038caa288aa1ba69e849b1607a12ea7c72dfca7a64ae892ff66e12851fde1908fb64a2c868ccdc826961aedc5669eec37e38ccc40109aa6567256ef7a11199d1f21b53144571023c8f0137b3f4dac0f3dc55acbacacfa00c5bf070fff68ac4d7da41ec2f66cb67de7ca9b30f810a85991d589181c6b3f5445e4a5990d80dfa3f37269f391ea20ea9b0a7d7e1897605e48a5e14fb74e76e70ab0ce8d55f480d64f1ecbcdff9b3f64e5724f828a3785f986db83217c3585364a4a0eebc318a8eb27fce1e95978fe5299e48e80d061a7adc5869c811930d863a4dac3966770da75716e51853c42194d50202cdf5bdd7e48928c80ede19a5c09381d7e9769fcde91eac9ab72d9c503a3a8cd4409fdf34d5e87a17136ef9d8b83d20e7b54fed949df31d76718d906e28af2f4397b8d08bc98ac42db7e84f80ddc06c03eac0f4deb099a12cd690232e9e12bdc6bb707ebbcf9b17f26d549467b988234ed0b7d20d6c3cb82dd7dae69ffce7e24c62ddda1f4882f0e6156625c8ad0cca2f1d32e402eaca40c5601d4679130fa25cf53a038217ec25878162b30db8fd4771f30ad03fe18b358e303911659287bc57635645bcf65f2368bc1ab7286322aa16369d201d1455361685ad09b7496ed08d596e74c10a8bbe481b01822dd7c0fbfa46888235505c360fcf46f3c6546bd8a0a7c8da91ba7fcbac8a3ed94bc2ae65ab2e2e373311cc9a38b06002e6f3ad6ef7926402abcacecd24c98f6382670087b54709741b3dd43de38c6951e6967c7bcd99d777c5f7f8495ae51025a8f0a61e8a7e85b92407da41b95e9003c86e898f740472ba843a0a21c07a026699924ab6d78e32f2facd2d2a8764a091073e8d68e64063c4b4965dfdf7c2b8e9a8f1733292631bce70e8746c70c86f48c32f0004e7d90456673344f5b8883a4bb77903b0ac9069f4ae9959ea996cdc1bab5b3bfe8603bcab1eff46ad2260939ffb4dd3c3bf82c9a796714523797b3dcf7cebb4113f8c1d03a4e82d80a9726fd3721a652ee7f6e8f483796b5c9a2f53290385b23ba920eb8e90563690f7285dbe5c28929610136e6f770c9f42285ebd6294622b0d6d2d9c8b6b92618a60f6744baa49236d12734dcf0fdbb76537e479b819fd2a0283b3f177925678ea3809345be2d30f1fd5f3d2b7e87e4dd9f843542de7f62e94c9bcfec9c829e273796098acfc6d0c21ec02d7bac26c428f9336df97f81f9b20c368f40c82c10721da55c23c80ef4b8c12cc7645044e19ea917fce1a1225ded86fa41878f294860eb742c6141c31b21e891f734650d116530d34e4d23583ce4394da7a8d044df118c20a096650c473f17ab67bc57d655441482d1c4c5ad7156af1fa3cb241e12d467c4871c69216303688793187862a4bc01ce58fedae1d225419f897a3c9659c66ac4180b651086881308f40392a5f66b7dfc4e4db11e7d5b80785251cc500c83297f9b52db78c154f08db21a358cfbc51896ad4fd3e4c2054904a0abc2ab7cc46a5b1bb2a1d71b773e8346b3c57c4229d04bc515d43f415a4a8a14e2e5508b8d9b2d7da494130965c1288d99355ff2e60e7ff76b90967ea8bca8776c7ad7ed9a34f539b5d7f7cf2df4269df4f7a495ed181f8650d5581f6e3804c5453462e6c556c4518c060e742d71941823a70f0560909e35d48a880e1136bde3c2f3291a92d47b97b700c545fcbc4a43c190d63b9983efaac396d959c5c7bde68db3141a8372bb4e71c23542850c79e5ad28d1151f58e664842f18c100ba768b4b202b5f4e231aa2b35f4450c370a6c86e47f4049cbb8bcf32884489a5dd6e2199727f6c04412dd9d6746eddac80fe7206e0bf94bf601281f6b371a5ba56da618be7e0a2aa17f439c9a9e1292a955eb4ea7d7192cd6451e2318e5569bac8a37a01f06b01391eb641d3b37ff024ebbc301ccd676a7c200c0667e30551ca6abbd0a49c50b40194fc12e9ede4205b2437571ca84712952a9f134d4c16697d91c6ffd04dfee3869037b26acbf0c9211bbe2603fbaafe283aa137b71d01aa0a6ac5e184a9393a4ee5af789cbbd0b80e3c449f0637eb956085df6222d41769ebffa1b11ffa67ac3981a7fe58ea59625e2");
    /**
     * The jump polynomial (2<sup>256</sup> steps).
     */
    public static final JumpPolynomial JUMP_EXP2_256 = new JumpPolynomial("838d493a230159529355d2bff6369761868b66787bbea13583a4743a1cb3763487a0ec4f8ec09dd5143a6854e24cd4ee1b18671f731d09785fd4fd72c124634a91c823dcfa4c2ffad2eb4166fa92d7d88c6810785f8bb58cb1b566eaba4e6fbc94b63bb553f34c14e77ed5f29f4e74ab2fdab2d3194289beefb14252ae0e56bed052ac9ab4a76d8779c575c2844fb7ef344f3a01da8c2088e84781ba39360dfde6c4058ea0eaf85ca810597bb9403ab46a4bf04823dab84c054f0b72f5cf70ded4698957ce268013d7728b595235d79b0d7db5193baacdb88565dd905f1bc328f05956da9aa37042ee7a192461c14ce8294b28fe9ba3f160e23a418b0efb64e1a622e8a3bb2405f481230167ac9dd15cb1f3db3d3be10271111e3c8b0749a0d09037d0af8e32606c1cf90d8c8218252cd1d3e84966e7da0dc91897cd0e6d1501f96b50691011fc1254ce720d11067fb8ebf4bdfdf1a64cf6702f515e46075b83846ca27b9357659f61cc6de21247e9010faa758489b66f3d841eb8e3ce4141cf5d950dc4fad3a3b3e73b9372f481033e11ac66239da30c80a201f49e9a53540d3ecdea63a22f247af03ba33dea8aee9596a681e53fc264afc425304538c28d71657441bb7a1d89cb3845d1d7853e591a78ddf097c479f9e1f50808e2bd6355087789529a1762eb5d45c8e45811be31b8b141bbe44ef980b7c7de6956f1f484dd151d88f303140f706d27dca2a87f33fadc34812f74250616a0bcb8d19dd2dfadbdfb1d2f5dfd0cc60e472f7942c8bc89f75c60a2e3b2eba4b197fb1dbe76b648eed27815c0c327d4e823ec26aecd654aed31f396d40ab69cca9a2e1326ff62a1bd52b931283de6d635191a46b1aa7d7c391fee95008eab9c39ccd772a7eab1d845bd8c5463e251dab657137fbd2790bce75b1234e9d7989b9538b92012f0674e566443fd964914a92d71fc42d0ea2c1c7bfa0d4925ad70ae677deda6fdd84e7388708f1ffa58ab91033e01360a6f17f3bf8fd0b9ee56065bcd3ddd4c0f8069761b3f4efcd8f66adc841459c185128830f468dd499f6b8798ef8c1b77d608b95642752775d1e87ee3896f5d8d2383454815be626ec7a6d8a2467e976c9967898bfdb46f52471fcdff4062d9f6270e24b9e2026b4b665901d45737cd52d540497003534301e2cb089f795b65dd55e3d8c0844a5aa9b39936413aabcd3cf6175478bc0da35444f37782da3e20b957695a4cf211f5db0026e4e516713b16ca2f444257fb989366e1b13d05b44a2bd8d186051e70c45a78805e77405679d22539b06cd632134459864fd9bbfd309b8394b437cc82bc2bcb584ae1d76e4e19ad6f4283464e0c44a5c455dde0e2915a31d1cd6b0b9e0796d03cff10f3de28ff7c56981e8135a1f059f0891c9b79746be79436391cb40d8dfc1f79ad5a0a3a2299ab9f37e1a1c1a2e513593acde72d7b3a06cb090730790cb59f13a327db68aad6b6fbcdcceb28745d237a84ae31d30b7b13c8d87a28ebc5168cd1a25a3f3491431e4e6959af1ea5227e1ac23f995e2b60b1f4147dc0024682ee3e3db583773ad41c5b4a96cf8697a9c44e1bdaa7092f9c5032edf8083788ffa642e1596d4ca3ea72f973f48f86dcccb843c5d0fe3664839c8ec618c198bfffbf6e877ac326eb84deb3c250563f3f6250ad1a75041e54f8596b501c0e1b53aa5a008b656570a2eeec40aa43bbc8ab7e74c90c54bd2229d749b7c09dcfd800541af1fc46db8187957694a55283b81d382562ad1349a3f6a77bf262eb14290f5ec3ac179d26144d91c908ff7bee247391c540e27a2bf41de1389fa5d2262fe2ab70610b35494600b32ae699b250f5585c6c583ddc80ce5faf732a24f860c9ea23bf24b0322ae70240aadfff6efef12b7fc380e53270c3c86fc75cb0f4d195628d768fbf6873d694c0d8ec0f6bb391a5d79437e5869dd9a84c09767fd4c8104f2d947123006a03873a5bbd126842a7d275f198d4fb16fb40b7f3229ab6758ffb76c7e8870bd7435eff4f56633acf479c51456fa9d302fffbebafd491af59e71b936ed750d7b3d4c70efb0266d24ac830dbfb2190cab20add60f55ffdb810cfb0cf74e953b47897959a3af6722cb1d783aba7602f9ae889f697bdb0a800951ba6c38a7f2eb2a30e688e74f8514ac47e295c12b15b1e406b0c37e625249efcc518403379a6b7bede010e1f361468eba431c154b001aba87ab3a781e48e98e32ad05122634e1e18994502f8ebe527b348c937734d9816802f17bb8dc7fc7dc7b624f60453ba4625023f1622e613a93b322e594d10b9c2d94370bd9b2bbfbff085bfd8bd53fae1c09cdddbd975556b98cd18d4311f5fd1b610f0695cd4d5d8a007cd9d624ee6346b40ff09f1f4ec941f8b6d89b64d95a20ab03ad0087a3040a52b398abe1292ec812ed8553c017e2ec982aa2a0afbe808618508b9d79371149f6c9c0e4292b87d0cb853b1e1b3cb8bf5ea8b6f7c32e0ff57e9bf77143b8a70e59eb510cf0b6533a0ce4f13af0e14f3c13befa22f9ba658c272b9267d1c40f0fb6fc5c98235a05f2aa3b1e165487857c36405aa52a63d43daa76cbf04e261cc56b542d8801dd88b2cb3768f774d7474326d9a2b89204c3361438d3c0861dc60474c9e0ace6f29528976d93f497016772654b889923414ff16f8c4faa9dbe87740f3a0102fe6cf207dc71c3a594b558dbbd7e71b93f19eff25be35b65fbb4a93957399be01a5dd732183652c71d92b51fd715ae8251d32203ae83d9d6cee446e0dfa87ded0ae7869af6432b8d83fd671d9b146edb7786a122b5cf660bc05063e45e33ca41f1ea661e29061b7fe294ddedce6bada6e9a4eff283c38669154a87f3cc97a3e22cb89507b7acd0ec2572efedeadeef66c3b29fd7fe4d9b9e930eafa886062fbb09d109d1048c9c2dbac7621234c2eee8a2d66208278a55b96f79784a4a1119b53956416a1c895bc24f363f912237a92914361a309c0a5fc5ff5ce6755a744796b2376ec25e3178321b8d7764b68fd593e7fceaffa668522a81d42510f7cdac80d5ef5eacf12245fd6f46843c5d7d622789c06a32ba42c65e61ac5f856fbcf6a0fcc6ae54ba660e0ad07a378481320e7f5e39e393f0d12c3d79ee074039078f1cbe2115cce934778c7a7d02ebd5873e145c174755a6438cf7cb20015b260dd0975be2f3b3e744d8c662de2d5bd950d82b4ef1e9433c0b23cb2785939311cdf33bbf8cb222616a32db9db063a992ba8957758b570454b23b7b030c8f7d85e9d0936245a290f793dc67812e8df53dab86455109a704361736e79b0e078abbd6dc28d9b7b863699d4bd5dfc5523dfaf4c4171f33106e65afce688acae1dc721b5128a91feaf05071abf2f1dbdb3e85480d540f8345f22a8660964e3ea6224e3b4c9f3016a7830fe10eab54d40773fef9c1c8f2fb8e952b38fd4822c76773d008549915ed79281fa5b2fb65293fb517a05d84d491adcc6b403fe972e9296f3db1f76bc7b9f17f0c216c6c9d60d");
    private static final int MEXP = 19937;
    private static final int N = MEXP / 128 + 1;
    private static final int N32 = N * 4;
    private static final int POS1 = 122;
    private static final int SL1 = 18;
    private static final int SL2 = 1;
    private static final int SR1 = 11;
    private static final int SR2 = 1;
    private static final int MSK1 = 0xdfffffef;
    private static final int MSK2 = 0xddfecb7f;
    private static final int MSK3 = 0xbffaffff;
    private static final int MSK4 = 0xbffffff6;
    private static final int PARITY1 = 0x00000001;
    private static final int PARITY2 = 0x00000000;
    private static final int PARITY3 = 0x00000000;
    private static final int PARITY4 = 0x13c9e684;
    private static final int[] parity = {PARITY1, PARITY2, PARITY3, PARITY4};
    private int[] psfmt32 = new int[N32];
    private int idx;
    
    /**
     * Creates a new generator.
     * <br>
     * This constructor sets the generator's initial state using the current time.
     */
    public SFMT19937() {
        int u = AtomicCounter.next();
        long nanos = System.nanoTime();
        init_by_array(u, (int)(nanos ^ (nanos >>> 32)));
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     */
    public SFMT19937(int seed) {
        init_gen_rand(seed);
    }
    
    /**
     * Creates a new generator.
     * @param seed the seed
     * @throws NullPointerException if {@code seed == null}
     */
    public SFMT19937(int... seed) {
        init_by_array(seed);
    }
    
    SFMT19937(SFMT19937 r) {
        System.arraycopy(r.psfmt32, 0, psfmt32, 0, N32);
        idx = r.idx;
    }
    
    private void init_gen_rand(int seed) {
        psfmt32[0] = seed;
        for (int i = 1; i < N32; i++) {
            psfmt32[i] = 1812433253 * (psfmt32[i - 1] ^ (psfmt32[i - 1] >>> 30)) + i;
        }
        idx = N32;
        period_certification();
    }
    
    private void init_by_array(int... init_key) {
        final int lag = 11;
        final int mid = 306;
        Arrays.fill(psfmt32, 0x8b8b8b8b);
        int count;
        if (init_key.length + 1 > N32) {
            count = init_key.length + 1;
        }
        else {
            count = N32;
        }
        int r = func1(psfmt32[0] ^ psfmt32[mid] ^ psfmt32[N32 - 1]);
        psfmt32[mid] += r;
        r += init_key.length;
        psfmt32[mid + lag] += r;
        psfmt32[0] = r;
        count--;
        int i, j;
        for (i = 1, j = 0; (j < count) && (j < init_key.length); j++) {
            r = func1(psfmt32[i] ^ psfmt32[(i + mid) % N32] ^ psfmt32[(i + N32 - 1) % N32]);
            psfmt32[(i + mid) % N32] += r;
            r += init_key[j] + i;
            psfmt32[(i + mid + lag) % N32] += r;
            psfmt32[i] = r;
            i = (i + 1) % N32;
        }
        for (; j < count; j++) {
            r = func1(psfmt32[i] ^ psfmt32[(i + mid) % N32] ^ psfmt32[(i + N32 - 1) % N32]);
            psfmt32[(i + mid) % N32] += r;
            r += i;
            psfmt32[(i + mid + lag) % N32] += r;
            psfmt32[i] = r;
            i = (i + 1) % N32;
        }
        for (j = 0; j < N32; j++) {
            r = func2(psfmt32[i] + psfmt32[(i + mid) % N32] + psfmt32[(i + N32 - 1) % N32]);
            psfmt32[(i + mid) % N32] ^= r;
            r -= i;
            psfmt32[(i + mid + lag) % N32] ^= r;
            psfmt32[i] = r;
            i = (i + 1) % N32;
        }
        idx = N32;
        period_certification();
    }
    
    private void period_certification() {
        int inner = 0;
        for (int i = 0; i < 4; i++) {
            inner ^= psfmt32[i] & parity[i];
        }
        for (int i = 16; i > 0; i >>= 1) {
            inner ^= inner >> i;
        }
        inner &= 1;
        if (inner == 1) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int work = 1;
            for (int j = 0; j < 32; j++) {
                if ((work & parity[i]) != 0) {
                    psfmt32[i] ^= work;
                    return;
                }
                work = work << 1;
            }
        }
    }
    
    private static int func1(int x) {
        return (x ^ (x >>> 27)) * 1664525;
    }
    
    private static int func2(int x) {
        return (x ^ (x >>> 27)) * 1566083941;
    }
    
    @Override
    public int nextBits() {
        if (idx >= N32) {
            gen_rand_all();
            idx = 0;
        }
        return psfmt32[idx++];
    }
    
    private void gen_rand_all() {
        int r1 = (N - 2) * 4;
        int r2 = (N - 1) * 4;
        int i;
        for (i = 0; i < N - POS1; i++) {
            do_recursion(i * 4, i * 4, (i + POS1) * 4, r1, r2);
            r1 = r2;
            r2 = i * 4;
        }
        for (; i < N; i++) {
            do_recursion(i * 4, i * 4, (i + POS1 - N) * 4, r1, r2);
            r1 = r2;
            r2 = i * 4;
        }
    }
    
    private void do_recursion(int r, int a, int b, int c, int d) {
        int x0 = psfmt32[a] << (SL2 * 8);
        int x1 = (psfmt32[a + 1] << (SL2 * 8)) | (psfmt32[a] >>> (32 - SL2 * 8));
        int x2 = (psfmt32[a + 2] << (SL2 * 8)) | (psfmt32[a + 1] >>> (32 - SL2 * 8));
        int x3 = (psfmt32[a + 3] << (SL2 * 8)) | (psfmt32[a + 2] >>> (32 - SL2 * 8));
        int y0 = (psfmt32[c + 1] << (32 - SR2 * 8)) | (psfmt32[c] >>> (SR2 * 8));
        int y1 = (psfmt32[c + 2] << (32 - SR2 * 8)) | (psfmt32[c + 1] >>> (SR2 * 8));
        int y2 = (psfmt32[c + 3] << (32 - SR2 * 8)) | (psfmt32[c + 2] >>> (SR2 * 8));
        int y3 = psfmt32[c + 3] >>> (SR2 * 8);
        psfmt32[r] = psfmt32[a] ^ x0 ^ ((psfmt32[b] >>> SR1) & MSK1) ^ y0 ^ (psfmt32[d] << SL1);
        psfmt32[r + 1] = psfmt32[a + 1] ^ x1 ^ ((psfmt32[b + 1] >>> SR1) & MSK2) ^ y1 ^ (psfmt32[d + 1] << SL1);
        psfmt32[r + 2] = psfmt32[a + 2] ^ x2 ^ ((psfmt32[b + 2] >>> SR1) & MSK3) ^ y2 ^ (psfmt32[d + 2] << SL1);
        psfmt32[r + 3] = psfmt32[a + 3] ^ x3 ^ ((psfmt32[b + 3] >>> SR1) & MSK4) ^ y3 ^ (psfmt32[d + 3] << SL1);
    }
    
    /**
     * Advances this generator's state with a small amount of calculation.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    @Override
    public void jump(JumpPolynomial jumpPoly) {
        int[] work = new int[N32];
        int index = idx;
        idx = N32;
        for (int i = 0; i < jumpPoly.degree(); i++) {
            int bits = jumpPoly.coefficientAt(i);
            for (int j = 0; j < 4; j++) {
                if ((bits & 1) != 0) {
                    add(work, 0, psfmt32, idx);
                }
                next_state();
                bits = bits >> 1;
            }
        }
        psfmt32 = work;
        idx = index;
    }
    
    private static void add(int[] dest, int dest_idx, int[] src, int src_idx) {
        int dp = dest_idx / 4;
        int sp = src_idx / 4;
        int diff = (sp - dp + N) % N;
        int i;
        for (i = 0; i < N - diff; i++) {
            int p = i + diff;
            for (int j = 0; j < 4; j++) {
                dest[i * 4 + j] ^= src[p * 4 + j];
            }
        }
        for (; i < N; i++) {
            int p = i + diff - N;
            for (int j = 0; j < 4; j++) {
                dest[i * 4 + j] ^= src[p * 4 + j];
            }
        }
    }
    
    private void next_state() {
        int i = (idx / 4) % N;
        int r1 = ((i + N - 2) % N) * 4;
        int r2 = ((i + N - 1) % N) * 4;
        do_recursion(i * 4, i * 4, ((i + POS1) % N) * 4, r1, r2);
        r1 = r2;
        r2 = i * 4;
        idx = idx + 4;
    }
    
    /**
     * Returns a new jumped generator.
     * @throws NullPointerException if {@code jumpPoly == null}
     */
    @Override
    public SFMT19937 copyAndJump(JumpPolynomial jumpPoly) {
        SFMT19937 r = new SFMT19937(this);
        r.jump(jumpPoly);
        return r;
    }
    
    void readyLongBits() {
        idx += idx & 0x1;
    }
    
}
