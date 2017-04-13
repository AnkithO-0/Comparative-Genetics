/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 */
package demo;

import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.Alignments.PairwiseSequenceAlignerType;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.core.alignment.SubstitutionMatrixHelper;
import org.biojava.nbio.alignment.template.GapPenalty;
import org.biojava.nbio.alignment.template.PairwiseSequenceAligner;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;

public class a1{

	public static void main(String[] args) throws Exception {

		String query = "AGGATGAACGCTGGCGGCGTGCTTAACACATGCAAGTCGAACGGTGAAGCCCAGCTTGCTGGGTGGATCA" +
		"GTGGCGAACGGGTGAGTAACACGTGAGCAACCTGCCCCTGACTCTGGGATAAGCGCTGGAAACGGTGTCT" +
		"AATACTGGATATGAGCTACCACCGCATGGTGAGTGGTTGGAAAGATTTTTCGGTTGGGGATGGGCTCGCG" +
		"GCCTATCAGCTTGTTGGTGAGGTAATGGCTCACCAAGGCGTCGACGGGTAGCCGGCCTGAGAGGGTGACC" +
		"GGCCACACTGGGACTGAGACACGGCCCAGACTCTACGGGAGGCAGCAGTGGGGAATATTGCACAATGGGC" +
		"GGAAGCCTGATGCAGCAACGCCGCGTGAGGGACGACGGCTTCGGGTTGTAAACCTCTTTTAGCAGGGAAG" +
		"AAGCGAGAGTGACGGTACCTGCAGAAAAAGCGCCGGCTAACTACGTGCCAGCAGCCGCGGTAATACGTAG" +
		"GGCGCAAGCGTTATCCGGAATTATTGGGCGTAAAGAGCTCGTAGGCGGTTTGTCGCGTCTGCTGTGAAAA" +
		"CCCGAGGCTCAACCTNNGGGCTGCAGTGGGTACGGGCAGACTAGAGTGCGGTAGGGGAGATTGGAATTCC" +
		"TGGTGTAGCGGTGGAATGCGCAGATATCAGGAGGAACACCGATGGCGAAGGCAGATCTCTGGGCCGTAAC" +
		"TGACGCTGAGGAGCGAAAGGGTGGGGAGCAAACAGGCTTAGATACCCTGGTAGTCCACCCCGTAAACGTT" +
		"GGGAACTAGTTGTGGGGTCCTTTCCACGGATTCCGTGACGCACGTAACGCATTAAGTTCCCCGCCTGGGG" +
		"AGTACGGCCGCAAGGCTAAAACTCAAAGGAATTGACGGGGACCCGCACAAGCGGCGGAGCATGCGGATTA" +
		"AATCGATGCAACGCGAAGAACCTTACCAAGGCTTGACATACACGAGAACGCTGCAGAAATGTAGAACTCT" +
		"TTGGACACTCGTGAACAGGTGGTGCATGGTTGTCGTCAGCTCGTGTCGTGAGATGTTGGGTTAAGTCCCG" +
		"CAACGAGCGCAACCCTCGTTCTATGTTGCCAGCACGTAATGGTGGGAACTCATGGGATACTGCCGGGGTC" +
		"AACTCGGAGGAAGGTGGGGATGACGTCAAATCATCATGCCCCTTATGTCTTGGGCTTCACGCATGCTACA" +
		"ATGGCCGGTACAAAGGGCTGCAATACCGTGAGGTGGAGCGAATCCCAAAAAGCCGGTCCCAGTTCGGATT" +
		"GAGGTCTGCAACTCGACCTCATGAAGTCGGAGTCGCTAGTAATCGCAGATCAGCAACGCTGCGGTGAATA" +
		"CGTTCCCGGGTCTTGTACACACCGCCCGTCAAGTCATGAAAGTCGGTAACACCTGAAGCCGGTGGCCTAA" +
		"CCCTTGTGGAGGGAGCCGGTAATTAAA";

		String target = "CTGGCCGCCTGCTTAACACATCCAAGTCGAACGGTGAAGCCCCANCTTACTGGGTGGATCAGTGCCGAAC" +
		"GGGTGAGTAACACGTGAGCAACCTCCCCCTGACTCTGGGATAAGCGCTGGAANCGGTGTCTAATACTGGA" +
		"TATGAGCTACCACCGCATGGTGAGTGGTTGGAAAGATTTTTCGGTTGGGGATGGGCTCGCGCCCTATGAG" +
		"CTTGTTGGTGAGGTAATGGCTCACCAAGCCGTCGACGGGTAGCCGGCCTGAGAGGGTGACCGNCCACACT" +
		"GGGACTGAGACACGGCCCAGACTCCTACGGGAGGCAGCAGTGGGGAATATTGCACAATGGGCGGAAGCCT" +
		"GATTCANCAACCCCGCGTGAGGGACGACGGCCTTCGGGTTGTAAACCTCTTTTAGCAGGGAAGAAGCGAG" +
		"AGTGACGGTACCTGCAGAAAAAGCCCCGGCTAACTACGTGCCAGCAGCCGCGGTAATACGTAGGGCGCAA" +
		"GCGTTATCCGGAATTATTGGGCGTAAAGAGCTCGTAGGCGGTTTGTCGCGTCTGCTGTGAAAACCCGAGG" +
		"CTCAACCTCGGGCCTGCAGTGGGTACGGGCAGACTAGAGTGCGGTAGGGGAGATTGGAATTCCTGGTGTA" +
		"GCGGTGGAATGCGCAGATATCAGGAGGAACACCGATGGCGAAGGCAGATCTCTGGGCCGTAACTGACGCT" +
		"GAGGAGCGAAAGGGTGGGGAGCAAACAGGCTTAGATACCCTGGTAGTCCACCCCGTAAACGTTGGGAACT" +
		"AGTTGTGGGGTCCTTTCCACGGATTCCGTGACGCAGCTAACGCATTAAGTTCCCCGCCTGGGGAGTACGG" +
		"CCGCAAGGCTAAAACTCAAAGGAATTGACGGGGACCCGCACAAGCGGCGGAGCATGCGGATTAATTCGAT" +
		"GCAACGCGAAGAACCTTACCAAGGCTTGACATACACGAGAACGCTGCAGAAATGTAGAACTCTTTGGACA" +
		"CTCGTGAACAGGTGGTGCATGGTTGTCGTCAGCTCGTGTCGTGAGATGTTGGGTTAAGTCCCGCAACGAG" +
		"CGCAACCCTCGTTCTATGTTGCCAGCACGTAATGGTGGGAACTCATGGGATACTGCCGGGGTCAACTCGG" +
		"AGGAAGGTGGGGATGACGTCAAATCATCATGCCCCTTATGTCTTGGGCTTCACGCATGCTACAATGGCCG" +
		"GTACAAAGGGCTGCAATACCGTGAGGTGGAGCGAATCCCAAAAAGCCGGTCCCAGTTCGGATTGAGGTCT" +
		"GCAACTCGACCTCATGAAGTCGGAGTCGCTAGTAATCGCAGATCAGCAACGCTGCGGTGAATACGTTCCC" +
		"GGGTCTTGTACACACCGCCCGTCAAGTCATGAAAGTCGGTAACACCTGAAGCCGGTGGCCCAACCCTTGT" +
		"GGAGGGAGCCGTCGAAGGTGGGATCGGTAATTAGGACTAAGTCGTAACAAGGTAGCCGTACC";

		GapPenalty penalty = new SimpleGapPenalty(5, 2);
		PairwiseSequenceAligner<DNASequence, NucleotideCompound> aligner = Alignments.getPairwiseAligner(
				new DNASequence(query, AmbiguityDNACompoundSet.getDNACompoundSet()),
				new DNASequence(target, AmbiguityDNACompoundSet.getDNACompoundSet()),
				PairwiseSequenceAlignerType.LOCAL,
				penalty, SubstitutionMatrixHelper.getNuc4_4());
		SequencePair<DNASequence, NucleotideCompound>
		alignment = aligner.getPair();

		System.out.println("Alignment: "+ alignment);

		int identical = alignment.getNumIdenticals();
		System.out.println("Number of identical residues: "+ identical);
		System.out.println("% identical query: "+ identical / (float) query.length());
		System.out.println("% identical target: "+ identical / (float) target.length());
	}
}
