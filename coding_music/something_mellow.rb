
my_scale = scale(:C3, :major)
melody_scale = scale(:C4, :major_pentatonic, num_octaves: 2)

define :strum do | nt |
  with_fx :reverb do
    with_fx :echo do
      play my_scale[nt]
      sleep 1
      play my_scale[nt] + 12, amp: 0.2
      sleep 3
    end
  end
end


live_loop :chords do
  use_synth :beep
  notes = ring(5, 4, 2, 3)
  strum notes.tick
end

live_loop :beat do
  with_fx :reverb, room: 0.7 do
    sample :drum_bass_soft
    sleep 1
    sample :drum_snare_soft
    sleep 2
    sample :drum_bass_soft
    sleep 0.25
    sample :drum_bass_soft
    sleep 0.75
  end
end


live_loop :arp do
  with_fx :reverb do
    with_fx :echo, decay: 0.5 do
      use_synth :kalimba
      play melody_scale.choose, release: 0.3, amp: 1
      sleep 0.5
    end
  end
end

live_loop :vocals do
  vox = "/Users/rafal/Downloads/voice_26_keyAmin_90bpm.wav"
  
  with_fx :reverb do
    sleep 8
    sample vox, amp: 0.3, pitch_stretch: 4
  end
end



